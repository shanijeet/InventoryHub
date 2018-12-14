package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model;


import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;

@Table(name = "LOC_DETAIL")
@Entity
//@JsonFilter("locationfilters")
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOC_KEY")

    private int loc_key;

    @Column(name = "LOC_ID")
    private long locid;


    @Column(name = "LOC_DESCRIPTION")
    private String loc_desc;

    @Column(name = "SERVER_PORT")
    private int serverport;

    /* @Column(name = "QUANTITY")
    private int quantity;*/

    public Location() {
    }

    public Location( int loc_key,Long locid, String loc_desc, int serverport) {
       
        this.loc_key=loc_key;
        this.locid = locid;
        this.loc_desc = loc_desc;
        //this.quantity = quantity;
        this.serverport=serverport;
    }

    public int getLoc_key() {
        return loc_key;
    }

    public void setLoc_key(int loc_key) {
        this.loc_key = loc_key;
    }

    public Long getLocid() {
        return locid;
    }

    public void setLocid(Long locid) {
        this.locid = locid;
    }

    public String getLoc_desc() {
        return loc_desc;
    }

    public void setLoc_desc(String loc_desc) {
        this.loc_desc = loc_desc;
    }

    public int getServerport() {
        return serverport;
    }

    public void setServerport(int serverport) {
        this.serverport = serverport;
    }

   /* public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }*/
}



