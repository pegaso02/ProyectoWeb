package com.proyectoWeb.PulmonVerde.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String author;
    String tittle;
    String description;
    String ImageUrl;


}
