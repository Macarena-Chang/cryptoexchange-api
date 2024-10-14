package com.example.cryptoexchange_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MercadoResponse {
    private Long id;
    private String codigo;
    private String descripcion;
    private PaisResponse pais;
}
