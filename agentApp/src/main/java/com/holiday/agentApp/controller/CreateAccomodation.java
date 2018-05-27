package com.holiday.agentApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.Picture;
import com.holiday.agentApp.model.Price;
import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.service.AccomodationService;
import com.holiday.agentApp.service.LocationService;
import com.holiday.agentApp.service.ObjectCategoryService;
import com.holiday.agentApp.service.ObjectTypeService;
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
	private ServicesService servicesService;
	@Autowired
	private ObjectTypeService objectTypeSerivce;
	
	@Autowired
	private ObjectCategoryService objectCategorySerivce;
	
	@RequestMapping(value="/addLocation",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		locationService.save(location);
		return new ResponseEntity<Location>(location,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getObjectType/{id}",method=RequestMethod.GET)
	public ResponseEntity<ObjectType> getObjectType(@PathVariable ("id") Long id){
		return new ResponseEntity<ObjectType>(objectTypeSerivce.getObjectType(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getObjectCategory/{id}",method=RequestMethod.GET)
	public ResponseEntity<ObjectCategory> getObjectCategory(@PathVariable ("id") Long id){
		ObjectCategory category=objectCategorySerivce.findById(id);
		System.out.println("Kategorija"+category.getCategory());
		return new ResponseEntity<ObjectCategory>(category,HttpStatus.OK);
	}
	@RequestMapping(value="/getLocation/{id}",method=RequestMethod.GET)
	public ResponseEntity<Location> getLocation(@PathVariable ("id") Long id){
		return new ResponseEntity<Location>(locationService.findById(id),HttpStatus.OK);
	}
	@RequestMapping(value="/addPrice",method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Price> addPrice(@RequestBody Price price){
		priceService.save(price);
		return new ResponseEntity<Price>(price,HttpStatus.OK);
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
			services.add(servicesService.findByOne(Long.parseLong(item)));
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
		
		for(Price item:prices){
			schedule.getPrice().add(item);
		}
		accomodation.setPriceShedule(schedule);
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
			item.setAccomodation(accomodation);
			accomodation.getPicture().add(item);
		}
		accomodationService.save(accomodation);
		
		return new ResponseEntity<Accomodation>(accomodation,HttpStatus.OK);
		
	}
}