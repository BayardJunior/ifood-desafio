package com.github.bayardjunior.ifood.application.controller;

import com.github.bayardjunior.ifood.domain.entity.Restaurant;
import com.github.bayardjunior.ifood.domain.exception.RestaurantAlreadyExistsException;
import com.github.bayardjunior.ifood.domain.model.CreateMenuDto;
import com.github.bayardjunior.ifood.domain.model.CreateRestaurantDto;
import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import com.github.bayardjunior.ifood.domain.service.RestaurantService;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/restaurant/{id}/menu")
    public RestaurantResponseDTO retrieveMenuByRestaurant(@PathVariable Long id){
        return restaurantService.retrieveMenuByRestaurant(id);
    }

    @PostMapping("/restaurant")
        public void createNewRestaurant(@Validated @RequestBody CreateRestaurantDto dto) throws RestaurantAlreadyExistsException {

        Restaurant restaurant = new Restaurant();
        restaurant.setDescription(dto.getDescription());
        restaurant.setName(dto.getName());
        restaurantService.createNewRestaurant(restaurant);

    }

    @PostMapping("/restaurant/{id}/menu")
    public void createNewMenu(@NotNull @PathVariable Long id, @Validated @RequestBody CreateMenuDto dto) {

        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.getMenuList().add(dto.getMenu());

        restaurantService.createNewMenu(restaurant);
    }
}
