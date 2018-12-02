package com.ftn.isa.projekat.rentACar.rentACarCore.config;
/*
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfiguration {

	
	

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Value("${spring.datasource.driver-class-name}")
	private String dataSourceClassName;

	
	@Bean(destroyMethod = "close")
    public DataSource dataSource() {
		
		log.debug("Initializing datasource...");

		
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(dataSourceClassName);
        config.addDataSourceProperty("url", dataSourceUrl);
        config.addDataSourceProperty("user", user);
        config.addDataSourceProperty("password", password);

        // MySQL specificna podesavanja u skladu sa HikariCP preporukama
        // Vise informacija na https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.addDataSourceProperty("useServerPrepStmts", true);

        return new HikariDataSource(config);
    }


}
*/