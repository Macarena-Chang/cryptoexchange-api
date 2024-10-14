package com.example.cryptoexchange_api.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.cryptoexchange_api.dto.StatsResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class StatsRepositoryImpl implements StatsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StatsResponse> getComitenteDistributionPorPaisyMarket() {
        String sql = "SELECT p.nombre AS country, m.codigo AS market, " +
                "COUNT(cm.comitente_id) AS comitente_count, " +
                "(SELECT COUNT(*) FROM comitente c " +
                "JOIN comitente_mercado cm2 ON c.id = cm2.comitente_id " +
                "JOIN mercado m2 ON cm2.mercado_id = m2.id " +
                "JOIN pais p2 ON m2.pais_id = p2.id " +
                "WHERE p2.id = p.id) AS total_comitentes_in_country " +
                "FROM comitente_mercado cm " +
                "JOIN mercado m ON cm.mercado_id = m.id " +
                "JOIN pais p ON m.pais_id = p.id " +
                "GROUP BY p.id, m.id";

        Query query = entityManager.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List<StatsResponse> statsResponses = new ArrayList<>();

        for (Object[] result : results) {
            String pais = (String) result[0];
            String mercado = (String) result[1];
            Long comitenteCount = ((Number) result[2]).longValue();
            Long totalComitentes = ((Number) result[3]).longValue();

            double percentage = (comitenteCount.doubleValue() / totalComitentes.doubleValue()) * 100;

            StatsResponse statsResponse = new StatsResponse(pais, mercado, percentage);
            statsResponses.add(statsResponse);
        }

        return statsResponses;
    }

}
