package com.example.cryptoexchange_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cryptoexchange_api.entities.Mercado;
import com.example.cryptoexchange_api.repos.MercadoRepository;

@Service
public class MercadoService {
    @Autowired
    private MercadoRepository mercadoRepository;

    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    public Mercado createMercado(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mercado not found"));
    }

    public Mercado updateMercado(Long id, Mercado mercadoDetails) {
        Mercado mercado = mercadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mercado not found"));

        mercado.setCodigo(mercadoDetails.getCodigo());
        mercado.setDescripcion(mercadoDetails.getDescripcion());
        mercado.setPais(mercadoDetails.getPais());

        return mercadoRepository.save(mercado);
    }

}
