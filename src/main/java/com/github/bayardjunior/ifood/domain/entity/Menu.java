package com.github.bayardjunior.ifood.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
