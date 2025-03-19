package com.kbg.game.conifg.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameDatabaseConfig {

    @ConfigurationProperties("spring.datasource.game")
    @Bean(name = "gameHikariConfig")
    public HikariConfig gameHikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = "gameHikariDataSource")
    public HikariDataSource gameHikariDataSource(@Qualifier("gameHikariConfig") HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

}
