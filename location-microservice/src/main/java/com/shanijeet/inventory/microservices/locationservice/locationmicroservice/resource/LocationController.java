package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.resource;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.InventoryAvailServiceProxy;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.Location;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class LocationController {


    @Autowired
    private LocationServiceImpl locationService;


    @Autowired
    Environment environment;

    @Autowired
    private InventoryAvailServiceProxy proxy;


    @RequestMapping(path = "/loc/{id}", method = RequestMethod.GET)
    public Location getLocbyID(@PathVariable long id)
    {
        System.out.println("Here");
        Location location= locationService.listLocbyid(id);
        /*location.setServerport(Integer.parseInt(environment.getProperty("local.server.port")));



        SimpleBeanPropertyFilter locationfilter=SimpleBeanPropertyFilter.filterOutAllExcept("locid","loc_desc","server_port");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("locationfilters",locationfilter);

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(location);

        mappingJacksonValue.setFilters(filterProvider);*/

        return location;

    }



    @Secured("ROLE_ADMIN")
    @RequestMapping(path = "admin/createloc",method = RequestMethod.POST)
    public ResponseEntity<String> creatLoc(@RequestBody Location location)
    {

        Location savedLocation=locationService.createLoc(location);


        //return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.TEXT_PLAIN).body("Location Created Successfully").;
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedLocation.getLocid()).toUri();

        ResponseEntity responseEntity=  ResponseEntity.created(uri).contentType(MediaType.TEXT_PLAIN).body("Location Created Successfully");
        return  responseEntity;
    }

    /*@RequestMapping(path = "/serachinv-feign/{locid}/{itemid}", method = RequestMethod.GET)
    public MappingJacksonValue findlocwithnv(@PathVariable long locid, @PathVariable long itemid){

        Location response=proxy.findavailInv(locid,itemid);
        Location location= locationService.listLocbyid(8.getLocid());

        Location location1=new Location(location.getLoc_key(),location.getLocid(),location.getLoc_desc(),response.getQuantity(),response.getServerport());


        SimpleBeanPropertyFilter locationfilter=SimpleBeanPropertyFilter.filterOutAllExcept("locid","loc_desc","quantity");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("locationfilters",locationfilter);

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(location1);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;



    }*/
}
