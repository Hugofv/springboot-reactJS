package com.squadra.blade.controllers;

import com.squadra.blade.entities.Rebelde;
import com.squadra.blade.services.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/sistema")
public class RebeldeController {

    @Autowired
    RebeldeService _sistemaService;

    @GetMapping("/filtro")
    public ResponseEntity<?> listarPorFiltro(@RequestParam(value = "descricao", defaultValue = "") String descricao,
                                             @RequestParam(value = "sigla", defaultValue = "") String sigla,
                                             @RequestParam(value = "email", defaultValue = "") String email) {
        List<Rebelde> sistemas = _sistemaService.listarPorFiltro(descricao, sigla, email);
        return new ResponseEntity(sistemas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Rebelde rebelde) {
        _sistemaService.criar(rebelde);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
