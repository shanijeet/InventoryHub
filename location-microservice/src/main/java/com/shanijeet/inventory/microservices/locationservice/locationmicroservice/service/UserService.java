package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.service;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.User;

public interface UserService {

    public User findbyusername(String username);


}
