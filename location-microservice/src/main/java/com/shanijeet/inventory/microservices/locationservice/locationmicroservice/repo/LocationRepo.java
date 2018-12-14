package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.repo;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Integer> {

 Location findAllByLocid(long locid);

}
