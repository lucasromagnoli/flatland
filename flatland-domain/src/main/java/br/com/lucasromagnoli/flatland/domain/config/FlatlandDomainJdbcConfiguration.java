package br.com.lucasromagnoli.flatland.domain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author github.com/lucasromagnoli
 * @since 29/01/2020
 */
@Configuration
@ComponentScan(basePackages = { FlatlandDomainConfigurationParameters.PACKAGE_REPOSITORY_JDBC })
public class FlatlandDomainJdbcConfiguration {

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
