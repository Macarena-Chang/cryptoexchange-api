package com.example.cryptoexchange_api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComitenteRequest {
    private String descripcion;
    private List<Long> mercadoIds; // Lista mercado ids asociados al comitente

}
