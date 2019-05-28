package com.star.wars.services;

import com.star.wars.entities.Rebelde;
import com.star.wars.repositories.RebeldeRepository;
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

    public List<Rebelde> listar() {
        return _rebeldeRepository.findAll();
    }
}
