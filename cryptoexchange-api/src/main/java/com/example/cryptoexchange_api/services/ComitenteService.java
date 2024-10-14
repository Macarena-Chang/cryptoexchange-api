package com.example.cryptoexchange_api.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cryptoexchange_api.dto.ComitenteRequest;
import com.example.cryptoexchange_api.dto.ComitenteResponse;
import com.example.cryptoexchange_api.dto.MercadoResponse;
import com.example.cryptoexchange_api.dto.PaisResponse;
import com.example.cryptoexchange_api.entities.Comitente;
import com.example.cryptoexchange_api.entities.Mercado;
import com.example.cryptoexchange_api.repos.ComitenteRepository;
import com.example.cryptoexchange_api.repos.MercadoRepository;

@Service
public class ComitenteService {

    @Autowired
    private ComitenteRepository comitenteRepository;
    @Autowired
    MercadoRepository mercadoRepository;

    public ComitenteResponse createComitente(ComitenteRequest comitenteRequest) {
        // check if existe description
        if (comitenteRepository.findByDescripcion(comitenteRequest.getDescripcion()).isPresent()) {
            throw new IllegalArgumentException("Comitente with this description already exists");
        }

        // Fetch mercados
        List<Mercado> mercados = mercadoRepository.findAllById(comitenteRequest.getMercadoIds());
        if (mercados.isEmpty()) {
            throw new IllegalArgumentException("At least one valid Mercado must be provided");
        }

        // Create Comitente
        Comitente comitente = new Comitente();
        comitente.setDescripcion(comitenteRequest.getDescripcion());
        // Set the relation (both ways) (Comitente -> Mercados and Mercado -> Comitente)
        comitente.setMercados(new HashSet<>(mercados)); // Associate mercados with the comitente

        // Update other side of the relationship
        for (Mercado mercado : mercados) {
            mercado.getComitentes().add(comitente); // Associate comitente with each mercado
        }

        Comitente savedComitente = comitenteRepository.save(comitente);

        // Convert Comitente to ComitenteResponse DTO
        return aComitenteResponse(savedComitente);

    }

    // Conversion logic from Comitente entity to DTO
    private ComitenteResponse aComitenteResponse(Comitente comitente) {
        ComitenteResponse response = new ComitenteResponse();
        response.setId(comitente.getId());
        response.setDescripcion(comitente.getDescripcion());

        // Convert mercados
        Set<MercadoResponse> mercadoResponses = comitente.getMercados().stream()
                .map(mercado -> {
                    MercadoResponse mercadoResponse = new MercadoResponse();
                    mercadoResponse.setId(mercado.getId());
                    mercadoResponse.setCodigo(mercado.getCodigo());
                    mercadoResponse.setDescripcion(mercado.getDescripcion());
                    return mercadoResponse;
                }).collect(Collectors.toSet());
        response.setMercados(mercadoResponses);

        return response;
    }

    private MercadoResponse toMercadoResponse(Mercado mercado) {
        MercadoResponse response = new MercadoResponse();
        response.setId(mercado.getId());
        response.setCodigo(mercado.getCodigo());
        response.setDescripcion(mercado.getDescripcion());

        // Convert pais
        PaisResponse paisResponse = new PaisResponse();
        paisResponse.setId(mercado.getPais().getId());
        paisResponse.setNombre(mercado.getPais().getNombre());
        response.setPais(paisResponse);

        return response;

    }

    public Comitente getComitenteById(Long id) {
        return comitenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comitente not found"));
    }

    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAll();
    }

    public Comitente updateComitente(Long id, Comitente comitenteDetails) {
        Comitente comitente = comitenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comitente not found"));
        comitente.setDescripcion(comitenteDetails.getDescripcion());
        return comitenteRepository.save(comitente);
    }

    public void deleteComitente(Long id) {
        Comitente comitente = comitenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comitente not found"));
        comitenteRepository.delete(comitente);
    }

}
