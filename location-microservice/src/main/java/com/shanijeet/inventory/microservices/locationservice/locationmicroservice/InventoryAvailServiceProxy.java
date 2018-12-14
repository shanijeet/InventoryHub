package com.shanijeet.inventory.microservices.locationservice.locationmicroservice;


import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.Location;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory-avail-microservice")
@RibbonClient(name = "inventory-avail-microservice")
@Component
public interface InventoryAvailServiceProxy {

    @RequestMapping(path = "/serachinv/{locid}/{itemid}", method = RequestMethod.GET)
    public Location findavailInv(@PathVariable("locid") long locid, @PathVariable("itemid") long itemid);


}
