package com.star.wars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = { StarWarsApplication.class, Jsr310JpaConverters.class })
public class StarWarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsApplication.class, args);
    }
}
