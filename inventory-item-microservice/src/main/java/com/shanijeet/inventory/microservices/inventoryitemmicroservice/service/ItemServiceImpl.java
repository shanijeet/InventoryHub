package com.shanijeet.inventory.microservices.inventoryitemmicroservice.service;

import com.shanijeet.inventory.microservices.inventoryitemmicroservice.model.Item;
import com.shanijeet.inventory.microservices.inventoryitemmicroservice.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl {

    @Autowired
    private ItemRepo itemRepo;

    public void createItem(Item item){


        itemRepo.save(item);
    }

    public Item searchItem(Long itemid){
        Item item=itemRepo.findAllByItemid(itemid);
        return item;
    }

    public List<Item> findallItems() {

        List<Item> itemList= itemRepo.findAll();
        return  itemList;
    }
}
