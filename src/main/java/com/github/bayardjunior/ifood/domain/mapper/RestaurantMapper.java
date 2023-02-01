package com.github.bayardjunior.ifood.domain.mapper;

import com.github.bayardjunior.ifood.domain.entity.Restaurant;
import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RestaurantMapper {

    public abstract RestaurantResponseDTO mapperToDto(Restaurant restaurant);
}
