package com.shanijeet.inventory.microservices.checkinventorymicroservice.proxy;


import com.shanijeet.inventory.microservices.checkinventorymicroservice.CheckInventoryMicroserviceApplication;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.model.CheckInventoryModel;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "location-microservice")
@RibbonClient(name = "location-microservice")
@Component
public interface LocationProxy {

    @RequestMapping(path = "/loc/{id}",method = RequestMethod.GET)
    public CheckInventoryModel getLocbyID(@PathVariable("id") long id);


}
