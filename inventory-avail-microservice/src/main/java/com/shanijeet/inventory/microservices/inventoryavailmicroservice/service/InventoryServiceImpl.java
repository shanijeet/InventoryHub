package com.shanijeet.inventory.microservices.inventoryavailmicroservice.service;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shanijeet.inventory.microservices.inventoryavailmicroservice.model.Inventory;
import com.shanijeet.inventory.microservices.inventoryavailmicroservice.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class InventoryServiceImpl {


    @Autowired
    private InventoryRepo inventoryRepo;


    public Inventory findavailableInv(long locid, long itemid){

        Inventory inventory=inventoryRepo.findAllByLocidAndItemid(locid, itemid);
        return inventory;
    }






}
