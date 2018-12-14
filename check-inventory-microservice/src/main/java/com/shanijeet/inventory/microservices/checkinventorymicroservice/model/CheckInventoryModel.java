package com.shanijeet.inventory.microservices.checkinventorymicroservice.model;

import org.springframework.stereotype.Component;

@Component
public class CheckInventoryModel {

    private long id;
    private long locid;
    private long itemid;
    private String quantity;

    public CheckInventoryModel() {
    }

    public CheckInventoryModel(long id, long locid, long itemid, String quantity) {
        this.id = id;
        this.locid = locid;
        this.itemid = itemid;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLocid() {
        return locid;
    }

    public void setLocid(long locid) {
        this.locid = locid;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
