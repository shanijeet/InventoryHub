package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.service;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.Location;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class LocationServiceImpl {


    @Autowired
    private LocationRepo locationRepo;

    public Location listLocbyid(long locid)
    {


      Location location=locationRepo.findAllByLocid(locid);

return location;

    }

    public Location createLoc(Location location) {

        locationRepo.save(location);
        return location;
    }
}
