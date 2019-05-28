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

    /**
     * Salva a instânica de {@link Rebelde} na base de dados.
     *
     * @param rebelde
     * @return
     */
    public Rebelde salvar(Rebelde rebelde) {

        return  _rebeldeRepository.save(rebelde);
    }
}
