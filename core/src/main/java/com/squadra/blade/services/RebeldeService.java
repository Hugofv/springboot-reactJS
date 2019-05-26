package com.squadra.blade.services;

import com.squadra.blade.entities.Rebelde;
import com.squadra.blade.repositories.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository _rebeldeRepository;


    public List<Rebelde> listarPorFiltro(String descricao, String sigla, String email) {
        return _rebeldeRepository.listarFiltro(descricao, sigla, email);
    }

    public Rebelde criar(Rebelde rebelde) {
        return  _rebeldeRepository.save(rebelde);
    }
}
