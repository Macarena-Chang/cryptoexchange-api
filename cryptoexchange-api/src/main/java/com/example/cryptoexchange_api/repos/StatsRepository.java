package com.example.cryptoexchange_api.repos;

import java.util.List;

import com.example.cryptoexchange_api.dto.StatsResponse;

public interface StatsRepository {
        List<StatsResponse> getComitenteDistributionPorPaisyMarket();

}
