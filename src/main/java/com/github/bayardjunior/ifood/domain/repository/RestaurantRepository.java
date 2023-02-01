package com.github.bayardjunior.ifood.domain.repository;

import com.github.bayardjunior.ifood.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT a FROM Restaurant a WHERE a.name =:name")
    Restaurant findRestaurantByName(@Param("name") String name);
}
