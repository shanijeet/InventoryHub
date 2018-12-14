package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.repo;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
