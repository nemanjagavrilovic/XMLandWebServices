package com.holiday.agentApp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.client.AccomodationClient;
import com.holiday.agentApp.client.CommentClient;
import com.holiday.agentApp.client.LocationClient;
import com.holiday.agentApp.client.ObjectCategoryClient;
import com.holiday.agentApp.client.ObjectTypeClient;
import com.holiday.agentApp.client.RatingClient;
import com.holiday.agentApp.client.ServiceClient;
import com.holiday.agentApp.client.UserClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Agent;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationFindResponse;
import com.holiday.agentApp.requestAndResponse.ObjectCategoryAllResponse;
import com.holiday.agentApp.requestAndResponse.ObjectTypeAllResponse;
import com.holiday.agentApp.requestAndResponse.ServiceAllResponse;
import com.holiday.agentApp.requestAndResponse.UserFindByEmailAndPasswordResponse;
import com.holiday.agentApp.service.AccomodationService;

@Controller
@RequestMapping("/accomodations")
public class AccomodationsController {

	@Autowired
	private LocationClient locationClient;

	@Autowired
	private ObjectCategoryClient categoryClient;

	@Autowired
	private ObjectTypeClient objectTypeClient;
	@Autowired
	private ServiceClient serviceClient;
	
	@Autowired
	private AccomodationService accomodationService;
	
	@Autowired
	private AccomodationClient accomodationClient;
	
	@Autowired
	private RatingClient ratingClient;

	@Autowired
	private CommentClient commentClient;
	
	@Autowired
	private UserClient userClient;
	@RequestMapping("/accomodation/{id}")
	public String getAccomodation(@PathVariable ("id") Long id,HttpServletRequest request){
	        
		Accomodation response= accomodationService.findById(id);
		JAXBElement<AccomodationFindResponse> inBigDataBase=accomodationClient.find(response);
		request.getSession().setAttribute("accom", response);
		request.getSession().setAttribute("comments", commentClient.getComments(inBigDataBase.getValue().getAccomodation()).getValue().getComment());
		request.getSession().setAttribute("ratings", 	ratingClient.findByAccomodation(inBigDataBase.getValue().getAccomodation()).getValue().getRating());
		return "forward:/accomodation.jsp";
	}
	
	@RequestMapping("/all")
	public String getAccomodations(HttpServletRequest request){
		
		List<Accomodation> accoms=accomodationService.findAll();
		request.getSession().setAttribute("accomodations", accoms);
		return "forward:/myAccomodations.jsp";
	}
	@RequestMapping("/publish/{id}")
	public ResponseEntity<?> publish(HttpServletRequest request,@PathVariable("id") Long id){
		TUser user=(TUser) request.getSession().getAttribute("user");
		Accomodation ac=accomodationService.findById(id);
		JAXBElement<ObjectCategoryAllResponse> objectCategory = (JAXBElement<ObjectCategoryAllResponse>) categoryClient
				.findAll();
		JAXBElement<ObjectTypeAllResponse> objectTypes = (JAXBElement<ObjectTypeAllResponse>) objectTypeClient
				.findAll();
		JAXBElement<ServiceAllResponse> services = serviceClient.findAll();
	
		JAXBElement<AccomodationFindResponse> saved=accomodationClient.find(ac);
		
		if(saved.getValue().getAccomodation()!=null){
			 return new ResponseEntity<Accomodation>(ac,HttpStatus.BAD_REQUEST);

		}else{
			for(ObjectCategory item:objectCategory.getValue().getObjectCategory()){
				if(item.getCategory().equals(ac.getCategory().getCategory())){
					ac.setCategory(item);
				}
			}
			for(ObjectType item:objectTypes.getValue().getObjectType()){
				if(item.getType().equals(ac.getType().getType())){
					ac.setType(item);
				}
			}
			List<Services> newServices=new ArrayList<Services>();
			for(Services item:services.getValue().getServices()){
				for(Services item2: ac.getServices()){
					if(item.getService().equals(item2.getService())){
						System.out.println("servis 1"+item.getService());

						System.out.println("servis 2"+item2.getService());
						newServices.add(item);
					}
				}
				
			}
				System.out.println(ac.getDescription());
				System.out.println(ac.getMaxPerson());
				System.out.println(ac.getName());
				System.out.println("C"+ac.getCategory().getId());
				System.out.println("T"+ac.getType().getId());
				System.out.println("L"+ac.getLocation().getId());
				JAXBElement<UserFindByEmailAndPasswordResponse> response=userClient.userFindByEmailAndPassword(user.getEmail(), user.getPassword());
				ac.setId(10L);
				ac.setServices(newServices);
				ac.setOwner((Agent)response.getValue().getUser());
				System.out.println("Owner"+ac.getOwner().getId());
				
				accomodationClient.save(ac);

		}
		return new ResponseEntity<Accomodation>(ac,HttpStatus.OK);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		Accomodation response=accomodationClient.find(accomodationService.findById(id)).getValue().getAccomodation();
		if(response!=null)
			accomodationClient.delete(response);
		accomodationService.delete(id);
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
	
} 
