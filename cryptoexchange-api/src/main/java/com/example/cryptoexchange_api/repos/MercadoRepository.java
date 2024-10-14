package com.example.cryptoexchange_api.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cryptoexchange_api.entities.Mercado;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {

}
