package com.holiday.agentApp.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.client.AccomodationClient;
import com.holiday.agentApp.client.ArrangmentClient;
import com.holiday.agentApp.client.LocationClient;
import com.holiday.agentApp.client.ObjectCategoryClient;
import com.holiday.agentApp.client.ObjectTypeClient;
import com.holiday.agentApp.client.ServiceClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationFindByOwnerResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindByAccOwnerResponse;
import com.holiday.agentApp.requestAndResponse.LocationResponse;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryAllResponse;
import com.holiday.agentApp.requestAndResponse.ObjectTypeAllResponse;
import com.holiday.agentApp.requestAndResponse.ServiceAllResponse;
import com.holiday.agentApp.service.AccomodationService;
import com.holiday.agentApp.service.ArrangmentService;
import com.holiday.agentApp.service.LocationService;
import com.holiday.agentApp.service.ObjectCategoryService;
import com.holiday.agentApp.service.ObjectTypeService;
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
	
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	private ResponseEntity<Object> login() throws URISyntaxException{
		JAXBElement<LocationResponse> object= (JAXBElement<LocationResponse>) locationClient.getAllLocations();
		JAXBElement<ObjectCategoryAllResponse> objectCategory= (JAXBElement<ObjectCategoryAllResponse>) categoryClient.findAll();
		JAXBElement<ObjectTypeAllResponse> objectTypes= (JAXBElement<ObjectTypeAllResponse>) objectTypeClient.findAll();
		JAXBElement<ServiceAllResponse> services=serviceClient.findAll();
	
		for(ObjectCategory item:objectCategory.getValue().getObjectCategory()){
			objectCategoryService.save(item);
		}
		for(ObjectType item:objectTypes.getValue().getObjectType()){
			objectTypeService.save(item);
		}
		for(Location location:object.getValue().getLocations()){
			locationService.save(location);
		}
		for(Services service:services.getValue().getServices()){
			servicesService.save(service);
		}
		JAXBElement<AccomodationFindByOwnerResponse> accomodations=accomodationClient.findByOwner(userService.findById(1L));
		for(Accomodation accomodation:accomodations.getValue().getAccomodation()){
			accomodationService.save(accomodation);
		}
		
		JAXBElement<ArrangmentFindByAccOwnerResponse> response=arrangmentClient.findByAccOwner(1L);
		for(Arrangment arr:response.getValue().getArrangment()){
			Accomodation re=accomodationService.find(arr.getAccomodation());
			TUser user=userService.findById(arr.getOwner().getId());
			if(user==null){
				TUser saved=userService.save(arr.getOwner());
				arr.setOwner(saved);
			}
			arr.setAccomodation(re);
			arrangmentService.save(arr);
		}
		URI uri=new URI("/createAccomodation/");
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setLocation(uri);
		
		return new ResponseEntity<>(uri, HttpStatus.OK);
	}
}
