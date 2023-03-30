package com.example.shop.repository;

import com.example.shop.models.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class ClientStatisticRepositoryImpl implements ClientStatisticRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String GET_CLIENT_STATISTIC = "select count as checkCount, originalCommonSum as totalPrice, discount as discountSum\n" +
            "from deal d \n" +
            "         join (select d.client_id, sum(dp.original_price) as originalCommonSum,\n" +
            "                      (sum(original_price) - sum(dp.original_price * (100 - dp.discount) / 100)) as discount\n" +
            "               from deal d\n" +
            "                        join deal_position dp on d.id = dp.deal_id\n" +
            "               where d.client_id = :clientId \n" +
            "               group by d.client_id) as ll on ll.client_id = d.client_id\n" +
            "         join (select d.client_id, count(*) as count\n" +
            "               from deal d\n" +
            "               where client_id = :clientId \n" +
            "               group by d.client_id) as c on c.client_id = d.client_id \n" +
            "limit 1 ";

    @Autowired
    public ClientStatisticRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Statistic getClientStatistic(long clientId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("clientId", clientId);
        return jdbcTemplate.query(GET_CLIENT_STATISTIC, parameters,
                rs -> rs.next()
                        ? new Statistic(rs.getInt("checkCount"), rs.getInt("totalPrice"), rs.getInt("discountSum"))
                        : null
        );
    }
}
