package com.shanijeet.inventory.microservices.inventoryavailmicroservice.controller;


import com.shanijeet.inventory.microservices.inventoryavailmicroservice.model.Inventory;
import com.shanijeet.inventory.microservices.inventoryavailmicroservice.service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryService;

    @Autowired
    Environment environment;

    @RequestMapping(path = "/serachinv/{locid}/{itemid}", method = RequestMethod.GET)
    public Inventory findavailInv(@PathVariable long locid, @PathVariable long itemid){
        Inventory inventory=inventoryService.findavailableInv(locid, itemid);

        inventory.setServerport(Integer.parseInt(environment.getProperty("local.server.port")));

        return inventory;
    }


}
