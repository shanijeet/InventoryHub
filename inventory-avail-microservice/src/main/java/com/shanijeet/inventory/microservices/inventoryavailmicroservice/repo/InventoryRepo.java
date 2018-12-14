package com.shanijeet.inventory.microservices.inventoryavailmicroservice.repo;

import com.shanijeet.inventory.microservices.inventoryavailmicroservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {

    public Inventory findAllByLocidAndItemid(long locid,long itemid);
}
