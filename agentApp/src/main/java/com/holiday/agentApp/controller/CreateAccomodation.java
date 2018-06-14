package com.holiday.agentApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.holiday.agentApp.client.LocationClient;
import com.holiday.agentApp.client.ObjectCategoryClient;
import com.holiday.agentApp.client.ObjectTypeClient;
import com.holiday.agentApp.client.ServiceClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.Picture;
import com.holiday.agentApp.model.Price;
import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.requestAndResponse.LocationByIdResponse;
import com.holiday.agentApp.requestAndResponse.ObjectTypeByIdResponse;
import com.holiday.agentApp.service.AccomodationService;
import com.holiday.agentApp.service.LocationService;
import com.holiday.agentApp.service.ObjectCategoryService;
import com.holiday.agentApp.service.ObjectTypeService;
import com.holiday.agentApp.service.PriceScheduleService;
import com.holiday.agentApp.service.PriceService;
import com.holiday.agentApp.service.ServicesService;

@Controller
@RequestMapping("/createAccomodation")
public class CreateAccomodation {

	@Autowired
	private AccomodationService accomodationService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private LocationService locationService;

	@Autowired
	private ObjectCategoryService objectCategoryService;
	
	@Autowired
	private ObjectTypeService objectTypeService;
	@Autowired
	private ServicesService servicesService;
	
	@Autowired
	private LocationClient locationClient;
	
	@Autowired
	private ObjectCategoryClient categoryClient;	
	
	@Autowired
	private ObjectTypeClient objectTypeClient;
	@Autowired
	private ServiceClient serviceClient;
	
	@Autowired
	private PriceScheduleService priceSheduleService;
	@RequestMapping(value="/")
	public String createAccomodatinoPage(HttpServletRequest request){
	
		
		request.getSession().setAttribute("locations", locationService.findAll());
		request.getSession().setAttribute("categories", objectCategoryService.findAll());
		request.getSession().setAttribute("types", objectTypeService.findAll());
		request.getSession().setAttribute("services", servicesService.findAll());
		
		return "forward:/createAccomodation.jsp";
	}
	
	@RequestMapping(value="/addLocation",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		locationClient.save(location);
		return new ResponseEntity<Location>(location,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getObjectType/{id}",method=RequestMethod.GET)
	public ResponseEntity<ObjectType> getObjectType(@PathVariable ("id") Long id){
		JAXBElement<ObjectTypeByIdResponse> response=objectTypeClient.findById(id);
		System.out.println("Type id"+response.getValue().getObjectType().getId());
		System.out.println("Type"+response.getValue().getObjectType().getType());
		
		return new ResponseEntity<ObjectType>(response.getValue().getObjectType(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getObjectCategory/{id}",method=RequestMethod.GET)
	public ResponseEntity<ObjectCategory> getObjectCategory(@PathVariable ("id") Long id){
		ObjectCategory category=categoryClient.findById(id).getValue().getObjectCategory();
		System.out.println("Kategorija id"+category.getId());
		System.out.println("Kategorija :"+category.getCategory());
		return new ResponseEntity<ObjectCategory>(category,HttpStatus.OK);
	}
	@RequestMapping(value="/getLocation/{id}",method=RequestMethod.GET)
	public ResponseEntity<Location> getLocation(@PathVariable ("id") Long id){
		JAXBElement<LocationByIdResponse> object= (JAXBElement<LocationByIdResponse>) locationClient.findByIdLocation(id);
		System.out.println(object.getValue().getLocation().getCity());
	
		return new ResponseEntity<Location>(object.getValue().getLocation(),HttpStatus.OK);
	}

	
	
	@RequestMapping(value="/getServices",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Services>> getServices(@RequestBody  Object ids){
		System.out.println(ids);
		List<String> servicesID=new ArrayList<String>();
		String [] s=ids.toString().substring(0,ids.toString().length()-2).split("=")[1].split(",");
		System.out.println(s);
		for(int i=0;i<s.length;i++){
			if(i==0)
				s[i]=s[i].substring(1);
			servicesID.add(s[i]);
		}
		System.out.println(servicesID);
		List<Services> services=new ArrayList<Services>();
		for(String item:servicesID){
			services.add(serviceClient.findById(Long.parseLong(item.trim())).getValue().getService());
		}
		return new ResponseEntity<List<Services>>(services,HttpStatus.OK);	
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<Accomodation> createAccomodation(@RequestBody Accomodation accomodation){
		System.out.println(accomodation.getMaxPerson());
		accomodationService.save(accomodation);
		return new ResponseEntity<Accomodation>(accomodation,HttpStatus.CREATED);
	}
	@RequestMapping(value="/setPriceShedule/{id}",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Accomodation> setPriceShedule(@RequestBody Object object,@PathVariable("id") Long id){
		PriceShedule schedule=new PriceShedule();
		ObjectMapper mapper = new ObjectMapper();
		List<Price> prices=new ArrayList<Price>();
		try {
			 prices = mapper.readValue( object.toString().substring(7),mapper.getTypeFactory().constructCollectionType(List.class, Price.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Accomodation accomodation=accomodationService.findById(id);
		
		PriceShedule saved=priceSheduleService.save(schedule);
		
		for(Price item:prices){
			item.setPriceShedule(saved);
			saved.getPrice().add(item);
			priceService.save(item);
			
		}
		PriceShedule saved1=priceSheduleService.save(schedule);
		accomodation.setPriceShedule(saved1);
		accomodationService.update(schedule,accomodation.getId());
		
		return new ResponseEntity<Accomodation>(accomodation,HttpStatus.OK);
		
	}
	@RequestMapping(value="/setPictures/{id}",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Accomodation> setPictures(@RequestBody Object object,@PathVariable("id") Long id){
		ObjectMapper mapper = new ObjectMapper();
		List<Picture> pictures=new ArrayList<Picture>();
		try {
			 pictures = mapper.readValue( object.toString().substring(9),mapper.getTypeFactory().constructCollectionType(List.class, Picture.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Accomodation accomodation=accomodationService.findById(id);
		
		for(Picture item:pictures){
			
			accomodation.getPicture().add(item);
		}
		accomodationService.save(accomodation);
		
		return new ResponseEntity<Accomodation>(accomodation,HttpStatus.OK);
		
	}
}