package com.star.wars.controllers;

import com.star.wars.entities.Rebelde;
import com.star.wars.exception.StarwarsMessageCode;
import com.star.wars.rest.util.BusinessException;
import com.star.wars.services.RebeldeService;
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
        return ResponseEntity.ok(rebelde);
    }

    @GetMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity listar() {
        List<Rebelde> rebeldes = _rebeldeService.listar();

        if(rebeldes.size() > 0) {
            return ResponseEntity.ok(rebeldes);
        }
        throw new BusinessException(StarwarsMessageCode.ERRO_NAO_POSSUI_REGISTROS);
    }
}
