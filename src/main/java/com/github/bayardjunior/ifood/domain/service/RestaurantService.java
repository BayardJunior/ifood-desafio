package com.github.bayardjunior.ifood.domain.service;

import com.github.bayardjunior.ifood.domain.entity.Menu;
import com.github.bayardjunior.ifood.domain.exception.MenuNotFoundException;
import com.github.bayardjunior.ifood.domain.mapper.MenuMapper;
import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import com.github.bayardjunior.ifood.domain.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    public RestaurantService(MenuMapper menuMapper, MenuRepository menuRepository) {
        this.menuMapper = menuMapper;
        this.menuRepository = menuRepository;
    }

    public RestaurantResponseDTO retrieveMenuByRestaurant(Long id) {
       Menu menu;
        if (!menuRepository.existsById(id)) {
            throw new MenuNotFoundException("Could not find a menu for this restaurant " + id);
        } else {
            menu = menuRepository.getById(id);
        }

        return menuMapper.mapperToDto(menu);

    }

}
