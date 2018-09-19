package com.gzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootShardingjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShardingjdbcApplication.class, args);
    }
}
