package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.service;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.User;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo  userRepo;



    @Override
    public User findbyusername(String username) {

        return userRepo.findByUsername(username);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = findbyusername(username);

        if( user == null ){
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }
}
