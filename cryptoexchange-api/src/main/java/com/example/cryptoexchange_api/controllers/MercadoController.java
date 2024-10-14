package com.example.cryptoexchange_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cryptoexchange_api.entities.Mercado;
import com.example.cryptoexchange_api.services.MercadoService;

@RestController
@RequestMapping("/api/mercados")

public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public List<Mercado> getAllMercados() {
        return mercadoService.getAllMercados();
    }

    @PostMapping
    public ResponseEntity<Mercado> createMercado(@RequestBody Mercado mercado) {
        Mercado newMercado = mercadoService.createMercado(mercado);
        return ResponseEntity.ok(newMercado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        Mercado mercado = mercadoService.getMercadoById(id);
        return ResponseEntity.ok(mercado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercadoDetails) {
        Mercado updatedMercado = mercadoService.updateMercado(id, mercadoDetails);
        return ResponseEntity.ok(updatedMercado);
    }

}
