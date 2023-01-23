package com.github.bayardjunior.ifood.application.controller;

import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import com.github.bayardjunior.ifood.domain.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    private RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurant/{id}/menu")
    public RestaurantResponseDTO retrieveMenuByRestaurant(@PathVariable Long id) {

        return restaurantService.retrieveMenuByRestaurant(id);
    }
}
