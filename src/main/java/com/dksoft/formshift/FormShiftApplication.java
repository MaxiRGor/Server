package com.dksoft.formshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableCaching
@SpringBootApplication(exclude =  HibernateJpaAutoConfiguration.class)
public class FormShiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormShiftApplication.class, args);
    }

}
