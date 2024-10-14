package com.example.cryptoexchange_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cryptoexchange_api.dto.StatsResponse;
import com.example.cryptoexchange_api.services.StatsService;

@RestController
@RequestMapping("/api")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public ResponseEntity<List<StatsResponse>> getComitenteDistribution() {
        List<StatsResponse> stats = statsService.getComitenteDistributionPorPaisyMarket();
        return ResponseEntity.ok(stats);
    }

}
