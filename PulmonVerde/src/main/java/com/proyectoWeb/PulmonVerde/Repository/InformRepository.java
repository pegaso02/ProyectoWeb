package com.proyectoWeb.PulmonVerde.Repository;

import com.proyectoWeb.PulmonVerde.Model.Inform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformRepository extends JpaRepository<Inform, Long> {




}
