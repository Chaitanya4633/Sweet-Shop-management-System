package com.sweetshop.sweetshop.config;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.repository.SweetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(SweetRepository sweetRepository) {
        return args -> {

            if (sweetRepository.count() == 0) {

                sweetRepository.save(new Sweet("Ladoo", "Indian", 10, 50));
                sweetRepository.save(new Sweet("Barfi", "Indian", 20, 30));
                sweetRepository.save(new Sweet("Jalebi", "Indian", 15, 40));
                sweetRepository.save(new Sweet("Rasgulla", "Indian", 25, 35));
                sweetRepository.save(new Sweet("Kaju Katli", "Indian", 30, 20));

                System.out.println("✅ Sample sweets loaded into database");
            }
        };
    }
}
