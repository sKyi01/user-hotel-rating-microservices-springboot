package com.springboot.user.services.external.services;

import com.springboot.user.services.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceFeignClient {


    @GetMapping("hotel/getHotelById/{id}")
    Hotel getHotelById(@PathVariable("id") String id);


}
