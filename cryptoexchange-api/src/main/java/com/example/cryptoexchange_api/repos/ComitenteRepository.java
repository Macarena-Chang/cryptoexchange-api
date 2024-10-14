package com.example.cryptoexchange_api.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cryptoexchange_api.entities.Comitente;

public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
    Optional<Comitente> findByDescripcion(String descripcion);

}
