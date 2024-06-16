package com.proyectoWeb.PulmonVerde.Controller;

import com.proyectoWeb.PulmonVerde.Model.Inform;
import com.proyectoWeb.PulmonVerde.Service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inform")
public class InformController {

    @Autowired
    private InformService informService;

    @PostMapping("/create")
    public ResponseEntity<Inform> crearInform(@RequestBody Inform inform) {
        Inform newInform = informService.createInform(inform);
        return ResponseEntity.ok().body(newInform);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inform> actualizarInform(@PathVariable Long id,  @RequestBody Inform inform) {
        Inform inform1 = informService.updateInform(id, inform);
        return ResponseEntity.ok().body(inform1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inform> deleteInform(@PathVariable Long id) {
        informService.deleteInform(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    public List<Inform> listarInform() {
        return informService.getAllInform();
    }

    @GetMapping("/{id}")
    public Inform getInformById(@PathVariable Long id) {
        return informService.getInformById(id);
    }

}
