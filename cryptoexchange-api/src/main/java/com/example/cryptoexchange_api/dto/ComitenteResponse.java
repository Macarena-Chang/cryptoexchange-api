package com.example.cryptoexchange_api.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComitenteResponse {
    private Long id;
    private String descripcion;
    private Set<MercadoResponse> mercados;

}
