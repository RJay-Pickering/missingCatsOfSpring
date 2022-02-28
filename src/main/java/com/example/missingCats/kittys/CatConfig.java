package com.example.missingCats.kittys;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CatConfig {

    @Bean
    CommandLineRunner commandLineRunner(CatRepository repository) {
        return args -> {
            Cat isabelle = new Cat(
                    1L,
                    "Isabelle",
                    "cute, brown with black patterns, missed dearly by her owner!",
                    13
            );

            Cat bo = new Cat(
                    2L,
                    "Bo",
                    "black body with brown underside, not missing but hes adorable!",
                    5
            );

            repository.saveAll(
                    List.of(isabelle, bo)
            );
        };
    }
}
