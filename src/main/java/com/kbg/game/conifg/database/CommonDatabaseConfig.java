package com.kbg.game.conifg.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonDatabaseConfig {

    @ConfigurationProperties("spring.datasource.common")
    @Bean(name = "commonHikariConfig")
    public HikariConfig commonHikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = "commonHikariDataSource")
    public HikariDataSource commonHikariDataSource(@Qualifier("commonHikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

}
