package com.careerit.scart.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfiguration {
//	@Bean
//	public DataSource dataSource() {
//		return DataSourceBuilder.create()
//				.driverClassName("com.mysql.cj.jdbc.Driver")
//				.username("root")
//				.password("root")
//				.url("jdbc:mysql://localhost:3306/scart")
//				.build();
//	}
//	@Bean
//		public JdbcTemplate jdbcTemplate() {
//			return new JdbcTemplate(dataSource());
//		}

}

