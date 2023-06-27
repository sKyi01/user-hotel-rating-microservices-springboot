package com.springboot.hotel.services.repository;

import com.springboot.hotel.services.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {


}
