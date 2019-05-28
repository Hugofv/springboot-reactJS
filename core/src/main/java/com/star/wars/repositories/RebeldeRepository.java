package com.squadra.blade.repositories;

import com.squadra.blade.entities.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {
    @Query("SELECT sis FROM Sistema sis WHERE sis.descricao = :descricao OR sis.sigla = :sigla OR sis.email = :email")
    List<Rebelde> listarFiltro(@Param("descricao") String descricao, @Param("sigla") String sigla, @Param("email") String email);
}
