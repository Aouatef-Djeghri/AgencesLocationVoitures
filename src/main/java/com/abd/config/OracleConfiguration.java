package com.abd.config;

import java.sql.SQLException;

import org.springframework.context.annotation.*;

@Configuration
@Profile("oracle")
public class OracleConfiguration {
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setUser("books");
//        dataSource.setPassword("books");
//        dataSource.setURL("jdbc:oracle:thin:@//localhost:11521/ORCLPDB1");
//        dataSource.setFastConnectionFailoverEnabled(true);
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setConnectionCachingEnabled(true);
//        return dataSource;
//    }
}