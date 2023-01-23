package com.github.bayardjunior.ifood.domain.repository;

import com.github.bayardjunior.ifood.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
