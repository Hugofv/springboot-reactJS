package com.squadra.blade.controllers;

import com.squadra.blade.entities.Rebelde;
import com.squadra.blade.services.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe de controle referente a entidade {@link Rebelde}.
 *
 * @author Hugo Fernandes
 */
@RestController
@RequestMapping("${app.api.base}/rebelde")
public class RebeldeController {

    @Autowired
    RebeldeService _rebeldeService;

    /**
     * Salva a instância de {@link Rebelde} na base de dados.
     *
     * @param rebelde
     * @return
     */
    @PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> criar(@RequestBody Rebelde rebelde) {
        _rebeldeService.salvar(rebelde);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
