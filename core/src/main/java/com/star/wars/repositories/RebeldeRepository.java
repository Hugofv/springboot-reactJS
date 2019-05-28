package com.star.wars.repositories;

import com.star.wars.entities.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebeldeRepository extends JpaRepository<Rebelde, Long> { }
