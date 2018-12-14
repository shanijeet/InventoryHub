package com.shanijeet.inventory.microservices.checkinventorymicroservice.proxy;

import com.shanijeet.inventory.microservices.checkinventorymicroservice.CheckInventoryMicroserviceApplication;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.model.CheckInventoryModel;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory-avail-microservice")
@RibbonClient(name = "inventory-avail-microservice")
@Component
public interface AvailInventoryProxy {

    @RequestMapping(path = "/serachinv/{locid}/{itemid}", method = RequestMethod.GET)
    public CheckInventoryModel findavailInv(@PathVariable("locid") long locid, @PathVariable("itemid") long itemid);
}
