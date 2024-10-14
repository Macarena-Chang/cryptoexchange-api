package com.example.cryptoexchange_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cryptoexchange_api.dto.StatsResponse;
import com.example.cryptoexchange_api.repos.StatsRepository;

@Service
public class StatsService {
    @Autowired
    private StatsRepository statsRepository;

    public List<StatsResponse> getComitenteDistributionPorPaisyMarket() {
        return statsRepository.getComitenteDistributionPorPaisyMarket();
    }

}
