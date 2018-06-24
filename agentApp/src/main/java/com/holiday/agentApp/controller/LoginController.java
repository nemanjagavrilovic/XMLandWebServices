package com.holiday.agentApp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.client.AccomodationClient;
import com.holiday.agentApp.client.ArrangmentClient;
import com.holiday.agentApp.client.LocationClient;
import com.holiday.agentApp.client.ObjectCategoryClient;
import com.holiday.agentApp.client.ObjectTypeClient;
import com.holiday.agentApp.client.RatingClient;
import com.holiday.agentApp.client.ServiceClient;
import com.holiday.agentApp.client.UserClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Agent;
import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.Rating;
import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationFindByOwnerResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindByAccOwnerResponse;
import com.holiday.agentApp.requestAndResponse.LocationResponse;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryAllResponse;
import com.holiday.agentApp.requestAndResponse.ObjectTypeAllResponse;
import com.holiday.agentApp.requestAndResponse.ServiceAllResponse;
import com.holiday.agentApp.requestAndResponse.UserFindByEmailAndPasswordResponse;
import com.holiday.agentApp.service.AccomodationService;
import com.holiday.agentApp.service.ArrangmentService;
import com.holiday.agentApp.service.LocationService;
import com.holiday.agentApp.service.ObjectCategoryService;
import com.holiday.agentApp.service.ObjectTypeService;
import com.holiday.agentApp.service.RatingService;
import com.holiday.agentApp.service.ServicesService;
import com.holiday.agentApp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AccomodationClient accomodationClient;

	@Autowired
	private ArrangmentClient arrangmentClient;

	@Autowired
	private LocationClient locationClient;

	@Autowired
	private ObjectCategoryClient categoryClient;

	@Autowired
	private ObjectTypeClient objectTypeClient;
	@Autowired
	private ServiceClient serviceClient;
	@Autowired
	private ArrangmentService arrangmentService;

	@Autowired
	private UserService userService;

	@Autowired
	private AccomodationService accomodationService;
	@Autowired
	private LocationService locationService;

	@Autowired
	private ObjectCategoryService objectCategoryService;

	@Autowired
	private ObjectTypeService objectTypeService;
	@Autowired
	private ServicesService servicesService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private RatingClient ratingClient;

	@Autowired
	private UserClient userClient;

	@RequestMapping(value="/logout")
	private String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "forward:/index.jsp";
	}
	@RequestMapping(value = "/signIn", method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Object> login(@RequestBody Agent userLogin,HttpServletRequest request) throws URISyntaxException {
		TUser loggedUser=null;
		
		if(userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword())!=null){
			loggedUser=userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
		}
		if (loggedUser != null & loggedUser instanceof Agent) {
			JAXBElement<LocationResponse> object = (JAXBElement<LocationResponse>) locationClient.getAllLocations();
			JAXBElement<ObjectCategoryAllResponse> objectCategory = (JAXBElement<ObjectCategoryAllResponse>) categoryClient
					.findAll();
			JAXBElement<ObjectTypeAllResponse> objectTypes = (JAXBElement<ObjectTypeAllResponse>) objectTypeClient
					.findAll();
			JAXBElement<ServiceAllResponse> services = serviceClient.findAll();
			List<ObjectCategory> categories = objectCategoryService.findAll();
			List<ObjectType> types=objectTypeService.findAll();
			List<Services> servicesIn=servicesService.findAll();
			for (ObjectCategory item : categories) {
				boolean flag = true;
				for (ObjectCategory newCategory : objectCategory.getValue().getObjectCategory()) {
					if (item.getCategory().equals(newCategory.getCategory())) {
						flag = false;
					}
				}
				if (flag == true) {
					objectCategoryService.delete(item.getId());
				}
			}
			
			for (ObjectCategory item : objectCategory.getValue().getObjectCategory()) {
				objectCategoryService.save(item);
			}
			for (ObjectType item : types) {
				boolean flag = true;
				for (ObjectType newType : objectTypes.getValue().getObjectType()) {
					if (item.getType().equals(newType.getType())) {
						flag = false;
					}
				}
				if (flag == true) {
					objectTypeService.delete(item.getId());
				}
			}
			for (ObjectType item : objectTypes.getValue().getObjectType()) {
				objectTypeService.save(item);
			}
			for (Location location : object.getValue().getLocations()) {
				locationService.save(location);
			}
			for (Services item : servicesIn) {
				boolean flag = true;
				for (Services newType : services.getValue().getServices()) {
					if (item.getService().equals(newType.getService())) {
						flag = false;
					}
				}
				if (flag == true) {
					servicesService.delete(item.getId());
				}
			}
			for (Services service : services.getValue().getServices()) {
				servicesService.save(service);
			}
			Agent a=(Agent) loggedUser;
			JAXBElement<ArrangmentFindByAccOwnerResponse> response = arrangmentClient.findByAccOwner(a.getPMB());
			arrangmentService.deleteAll();
			for (Arrangment arr : response.getValue().getArrangment()) {
				Accomodation re = accomodationService.find(arr.getAccomodation());
				TUser user = userService.findById(arr.getOwner().getId());
				if (user == null) {
					TUser saved = userService.save(arr.getOwner());
					arr.setOwner(saved);
				}
				arr.setAccomodation(re);
				arr.setId(null);
				arrangmentService.save(arr);
			}
			System.out.println("PROSLOOOOOO 2.");
			
			URI uri = new URI("/agent1/createAccomodation/");
			HttpHeaders httpHeaders = new HttpHeaders();

			httpHeaders.setLocation(uri);
			request.getSession().setAttribute("user", loggedUser);
			return new ResponseEntity<>(uri, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
}
