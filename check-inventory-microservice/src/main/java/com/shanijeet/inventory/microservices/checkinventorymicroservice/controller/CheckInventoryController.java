package com.shanijeet.inventory.microservices.checkinventorymicroservice.controller;


import com.shanijeet.inventory.microservices.checkinventorymicroservice.CheckInventoryMicroserviceApplication;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.model.CheckInventoryModel;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.proxy.AvailInventoryProxy;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.proxy.ItemProxy;
import com.shanijeet.inventory.microservices.checkinventorymicroservice.proxy.LocationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckInventoryController {


    @Autowired
    private AvailInventoryProxy availInventoryProxy;
    @Autowired
    private LocationProxy locationProxy;
    @Autowired
    private ItemProxy itemProxy;

    @RequestMapping(path="/checkinv/{locid}/{itemid}",method = RequestMethod.GET)
    public CheckInventoryModel checkInventory(@PathVariable long locid, @PathVariable long itemid)

    {
        CheckInventoryModel checklocation=locationProxy.getLocbyID(locid);

        CheckInventoryModel checkItem=itemProxy.findItem(itemid);

        CheckInventoryModel checkInventory1 = null;

        if(checklocation!=null && checkItem!=null)
        {

            checkInventory1=availInventoryProxy.findavailInv(checklocation.getLocid(),checkItem.getItemid());
        }
        
        return checkInventory1;
        
        
    }


}
