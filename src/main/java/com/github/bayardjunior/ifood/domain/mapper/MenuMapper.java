package com.github.bayardjunior.ifood.domain.mapper;

import com.github.bayardjunior.ifood.domain.entity.Menu;
import com.github.bayardjunior.ifood.domain.model.RestaurantResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MenuMapper {

    public abstract RestaurantResponseDTO mapperToDto(Menu menu);
}
