package com.shanijeet.inventory.microservices.inventoryavailmicroservice.model;


import javax.persistence.*;

@Entity
@Table(name = "LOC_ITEM_INVENTORY")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="INVENTORY_KEY")
    private int inventorykey;
    @Column(name="LOC_ID")
    private long locid;
    @Column(name="ITEM_ID")
    private long itemid;
    @Column(name="QUANTITY")
    private long quantity;
    @Column(name="SERVER_PORT")
    private int serverport;


    public Inventory() {
    }

    public Inventory(long locid, long itemid, long quantity) {
       this.inventorykey = inventorykey;
        this.locid = locid;
        this.itemid = itemid;
        this.quantity = quantity;
    }

   public int getInventorykey() {
        return inventorykey;
    }

    public void setInventorykey(int inventorykey) {
        this.inventorykey = inventorykey;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getServerport() {
        return serverport;
    }

    public void setServerport(int serverport) {
        this.serverport = serverport;
    }
}

