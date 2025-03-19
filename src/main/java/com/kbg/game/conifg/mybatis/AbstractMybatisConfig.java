package com.kbg.game.conifg.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public abstract class AbstractMybatisConfig {

    protected HikariDataSource dataSource;
    protected String mapperLocationsPath;
    private static final String TYPE_ALIASES_PACKAGE = "com.kbg.game.model";

    protected SqlSessionFactoryBean getSqlSessionFactoryBean() throws Exception {
        Configuration configuration = new Configuration();
        configuration.setLazyLoadingEnabled(Boolean.TRUE);
        configuration.setCacheEnabled(Boolean.FALSE);
        configuration.setUseGeneratedKeys(Boolean.TRUE);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setMapUnderscoreToCamelCase(Boolean.TRUE);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setCallSettersOnNulls(Boolean.TRUE);

        PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        sessionFactoryBean.setMapperLocations(pathResolver.getResources(this.mapperLocationsPath));
        sessionFactoryBean.setConfiguration(configuration);

        return sessionFactoryBean;
    }

    public abstract SqlSessionFactory getSqlSessionFactory() throws Exception;

    public abstract DataSourceTransactionManager getTransactionManager();

}
