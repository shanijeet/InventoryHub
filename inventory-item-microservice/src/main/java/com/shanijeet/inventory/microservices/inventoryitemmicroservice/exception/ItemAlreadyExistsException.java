package com.shanijeet.inventory.microservices.inventoryitemmicroservice.exception;

public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException(String s) {
        super(s);
    }
}
