package com.example.missingCats.comment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CommentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CommentRepository repository) {
        return args -> {
            Comment mariam = new Comment(
                    1L,
                    1,
                    1,
                    "hi"
            );

            Comment alex = new Comment(
                    2L,
                    2,
                    2,
                    "hi"
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}