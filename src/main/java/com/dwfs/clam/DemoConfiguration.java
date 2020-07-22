package com.dwfs.clam;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.sql.SQLException;

@Configuration
public class DemoConfiguration {
	@Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${jdbc.initialSize}")
    private int jdbcInitialSize;

    @Value("${jdbc.minIdle}")
    private int jdbcMinIdle;

    @Value("${jdbc.maxActive}")
    private int jdbcMaxActive;

    @Value("${jdbc.maxWait}")
    private int jdbcMaxWait;

    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private long jdbcTimeBetweenEvictionRunsMillis;

    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private long jdbcMinEvictableIdleTimeMillis;

    @Value("${jdbc.testWhileIdle}")
    private boolean jdbcTestWhileIdle;

    @Value("${jdbc.testOnBorrow}")
    private boolean jdbcTestOnBorrow;

    @Value("${jdbc.testOnReturn}")
    private boolean jdbcTestOnReturn;
    
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource setDataSource() throws SQLException {
            DruidDataSource ds = new DruidDataSource();
            ds.setUrl(jdbcUrl);
            ds.setUsername(jdbcUsername);
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            ds.setPassword(jdbcPassword);
            ds.setInitialSize(jdbcInitialSize);
            ds.setMinIdle(jdbcMinIdle);
            ds.setMaxActive(jdbcMaxActive);
            ds.setMaxWait(jdbcMaxWait);
            ds.setTimeBetweenEvictionRunsMillis(jdbcTimeBetweenEvictionRunsMillis);
            ds.setMinEvictableIdleTimeMillis(jdbcMinEvictableIdleTimeMillis);
            ds.setValidationQuery("select 'x'");
            ds.setTestWhileIdle(jdbcTestWhileIdle);
            ds.setTestOnBorrow(jdbcTestOnBorrow);
            ds.setTestOnReturn(jdbcTestOnReturn);
            // ds.setPoolPreparedStatements(false);
            ds.setFilters("stat, slf4j");

            return ds;
        

    }
    
   
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory() throws Exception{
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(setDataSource());

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        factory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver =
                new PathMatchingResourcePatternResolver();
        String packageSearchPath = "classpath*:mapping/*.xml";
        factory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
         return factory.getObject();
        
    }

}
