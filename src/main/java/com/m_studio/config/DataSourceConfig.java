package com.m_studio.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration public class DataSourceConfig { @Bean public DataSource getDataSource() { return DataSourceBuilder.create() .driverClassName("com.mysql.cj.jdbc.Driver") .url("jdbc:mysql://localhost:3306/mstudio6") .username("root") .password("root") .build(); } }

//Read more: https://www.java67.com/2023/04/how-to-fix-cannot-determine-embedded.html#ixzz8OL11efPo
