package com.example.cryptoexchange_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cryptoexchange_api.dto.ComitenteRequest;
import com.example.cryptoexchange_api.dto.ComitenteResponse;
import com.example.cryptoexchange_api.entities.Comitente;
import com.example.cryptoexchange_api.services.ComitenteService;

@RestController
@RequestMapping("/api/comitente")
public class ComitenteController {

    @Autowired
    private ComitenteService comitenteService;

    /*
     * @PostMapping
     * public ResponseEntity<Comitente> createComitente(@RequestBody Comitente
     * comitente) {
     * Comitente newComitente = comitenteService.createComitente(comitente);
     * return ResponseEntity.ok(newComitente);
     * }
     */
    @PostMapping
    public ResponseEntity<ComitenteResponse> createComitente(@RequestBody ComitenteRequest comitenteRequest) {
        ComitenteResponse newComitente = comitenteService.createComitente(comitenteRequest);
        return ResponseEntity.ok(newComitente);
    }

    @GetMapping
    public List<Comitente> getAllComitentes() {
        return comitenteService.getAllComitentes();
    }
}
