package com.example.cryptoexchange_api.dto;

import java.util.Map;

public class StatsResponse {
    private String pais;
    private Map<String, Double> mercado;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Map<String, Double> getMercado() {
        return mercado;
    }

    public void setMercado(Map<String, Double> mercado) {
        this.mercado = mercado;
    }

    public StatsResponse(String pais, Map<String, Double> mercado) {
        this.pais = pais;
        this.mercado = mercado;
    }

    public StatsResponse(String pais, String mercado, double percentage) {
        this.pais = pais;
        this.mercado = Map.of(mercado, percentage);
    }

}
