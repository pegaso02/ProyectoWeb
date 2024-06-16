package com.proyectoWeb.PulmonVerde.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tittle;
    String comment;
    String author;
    LocalDateTime creationDate;


}
