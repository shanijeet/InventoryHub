package com.shanijeet.inventory.microservices.inventoryitemmicroservice.model;


import javax.persistence.*;

@Entity
@Table(name = "ITEM_DETAIL")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_KEY")
    private int itemkey;

    @Column(name = "ITEM_ID")
    private long itemid;

    @Column(name = "ITEM_ACTIVE")
    private String  flag;

    @Column(name = "ITEM_DESCRIPTION")
    private String dcesription;

    @Column(name = "ITEM_PRICE")
    private Double price;

    @Column(name = "SERVER_PORT")
    private int port;



    public Item() {
    }

    public Item(long itemid, String flag, String dcesription, Double price) {
        this.itemid = itemid;
        this.flag = flag;
        this.dcesription = dcesription;
        this.price = price;
    }


    public int getItemkey() {
        return itemkey;
    }

    public void setItemkey(int itemkey) {
        this.itemkey = itemkey;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDcesription() {
        return dcesription;
    }

    public void setDcesription(String dcesription) {
        this.dcesription = dcesription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
