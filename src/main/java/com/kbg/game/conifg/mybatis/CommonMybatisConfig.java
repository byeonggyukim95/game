package com.kbg.game.conifg.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.kbg.game.conifg.mapper.common", sqlSessionFactoryRef = "commonSqlSessionFactory")
public class CommonMybatisConfig extends AbstractMybatisConfig {

    @Autowired
    public CommonMybatisConfig(@Lazy @Qualifier("commonHikariDataSource") HikariDataSource dataSource) {
        this.dataSource = dataSource;
        this.mapperLocationsPath = "classpath:/sql/common/*.xml";
    }

    @Override
    @Bean(name = "commonSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        return super.getSqlSessionFactoryBean().getObject();
    }

    @Override
    @Bean(name = "commonTransactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}