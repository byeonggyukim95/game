package com.kbg.game.conifg.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.kbg.game.conifg.mapper.game", sqlSessionFactoryRef = "gameSqlSessionFactory")
public class GameMybatisConfig extends AbstractMybatisConfig {

    @Autowired
    public GameMybatisConfig(@Lazy @Qualifier("gameHikariDataSource") HikariDataSource dataSource) {
        this.dataSource = dataSource;
        this.mapperLocationsPath = "classpath:/sql/game/*.xml";
    }

    @Override
    @Bean(name = "gameSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        return super.getSqlSessionFactoryBean().getObject();
    }

    @Override
    @Bean(name = "gameTransactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
