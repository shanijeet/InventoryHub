package com.shanijeet.inventory.microservices.inventoryitemmicroservice.repo;

import com.shanijeet.inventory.microservices.inventoryitemmicroservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {

    public Item findAllByItemid(long itemid);
}
