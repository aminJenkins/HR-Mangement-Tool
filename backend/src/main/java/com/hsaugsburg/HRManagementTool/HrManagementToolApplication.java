package com.hsaugsburg.HRManagementTool;

import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class HrManagementToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagementToolApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ZugangsRepo zugangsRepo, PasswordEncoder encoder) {
        return args -> {

            if (zugangsRepo.findByUsername("max.musterman@gmail.com").isEmpty())
                zugangsRepo.save(new ZugangEntity("max.musterman@gmail.com", encoder.encode("password"), "ROLE_USER"));

            if (zugangsRepo.findByUsername("kai.musterman@gmail.com").isEmpty())
                zugangsRepo.save(new ZugangEntity("kai.musterman@gmail.com", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));

            if (zugangsRepo.findByUsername("rudolf.musterman@gmail.com").isEmpty())
                zugangsRepo.save(new ZugangEntity("rudolf.musterman@gmail.com", encoder.encode("password"), "ROLE_USER"));
        };
    }
}