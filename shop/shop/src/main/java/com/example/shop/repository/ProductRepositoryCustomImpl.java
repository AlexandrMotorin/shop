package com.example.shop.repository;

import com.example.shop.models.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String GET_PRODUCT_STATISTIC = "select count, originalCommonSum, ll.discount \n" +
            "from deal_position dp \n" +
            "         join (select dp.product_id,\n" +
            "                      sum(dp.original_price) as originalCommonSum,\n" +
            "                      (sum(original_price) - sum(dp.original_price * (100 - dp.discount) / 100)) as discount\n" +
            "               from deal d\n" +
            "                        join deal_position dp on d.id = dp.deal_id\n" +
            "               where dp.product_id = :productId\n" +
            "               group by dp.product_id\n" +
            "            ) as ll on ll.product_id = dp.product_id\n" +
            "        join (select p.product_id, count(*) as count from deal d\n" +
            "                              join deal_position p on d.id = p.deal_id\n" +
            "                       where p.product_id = :productId\n" +
            "                       group by p.product_id) as c on c.product_id = dp.product_id\n" +
            "limit 1";

    @Autowired
    public ProductRepositoryCustomImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Statistic getProductStatistic(long productId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("productId", productId);
        return jdbcTemplate.query(GET_PRODUCT_STATISTIC, parameters,
                rs -> rs.next()
                        ? new Statistic(rs.getInt("checkCount"), rs.getInt("totalPrice"), rs.getInt("discountSum"))
                        : null
        );
    }
}
