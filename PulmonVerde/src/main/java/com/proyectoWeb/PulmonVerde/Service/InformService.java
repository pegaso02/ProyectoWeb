package com.proyectoWeb.PulmonVerde.Service;

import com.proyectoWeb.PulmonVerde.Exceptions.NotFoundException;
import com.proyectoWeb.PulmonVerde.Model.Inform;
import com.proyectoWeb.PulmonVerde.Repository.InformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformService {

    @Autowired
    private InformRepository informRepository;


    public Inform createInform(Inform inform) {
        return informRepository.save(inform);
    }

    public Inform updateInform(Long id, Inform inform) {
        Optional<Inform> inform1 = informRepository.findById(id);
        if (inform1.isPresent()) {
            Inform inform2 = inform1.get();
            inform2.setTittle(inform.getTittle());
            inform2.setDescription(inform.getDescription());
            inform2.setImageUrl(inform.getImageUrl());
            inform2.setAuthor(inform.getAuthor());
            return informRepository.save(inform);
        }
        throw new RuntimeException("Informe no encontrado");
    }

    public void deleteInform(Long id) {
        Optional<Inform> inform1 = informRepository.findById(id);
        if (inform1.isPresent()) {
            informRepository.delete(inform1.get());
        } else{
            throw new NotFoundException("Informe no encontrado");
        }
    }

    public List<Inform> getAllInform(){
        return informRepository.findAll();
    }

    public Inform getInformById(Long id) {
        return informRepository.findById(id).get();
    }
}
