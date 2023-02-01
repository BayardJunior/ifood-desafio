package com.github.bayardjunior.ifood.domain.service;

import com.github.bayardjunior.ifood.domain.entity.Restaurant;
import com.github.bayardjunior.ifood.domain.exception.MenuNotFoundException;
import com.github.bayardjunior.ifood.domain.exception.RestaurantAlreadyExistsException;
import com.github.bayardjunior.ifood.domain.mapper.RestaurantMapper;
import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import com.github.bayardjunior.ifood.domain.repository.MenuRepository;
import com.github.bayardjunior.ifood.domain.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantMapper restaurantMapper;

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantMapper restaurantMapper, RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public RestaurantResponseDTO retrieveMenuByRestaurant(Long id) {
        Restaurant menu;
        checkIfRestaurantExistsById(id);

        menu = restaurantRepository.getById(id);

        RestaurantResponseDTO dto = new RestaurantResponseDTO();
        dto.setId(menu.getId());
        dto.setDescription(menu.getDescription());
        dto.setMenuList(menu.getMenuList());

        return dto;

    }

    public void createNewRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        if (restaurantRepository.findRestaurantByName(restaurant.getName()) != null) {
            throw new RestaurantAlreadyExistsException("Restaurant already exists, please choose another name into it" + restaurant.getName());
        }
        restaurantRepository.save(restaurant);
    }

    public void createNewMenu(Restaurant restaurant) {
        checkIfRestaurantExistsById(restaurant.getId());
        Restaurant found = findById(restaurant.getId());
        restaurant.setName(found.getName());
        restaurant.setDescription(found.getDescription());
        restaurant.getMenuList().addAll(found.getMenuList());
        restaurant.getMenuList().forEach(menuRepository::saveAndFlush);

        restaurantRepository.save(restaurant);
    }

    private void checkIfRestaurantExistsById(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new MenuNotFoundException("Could not find a menu for this restaurant " + id);
        }
    }

    private Restaurant findById(Long id) {
        return restaurantRepository.findById(id).get();
    }
}
