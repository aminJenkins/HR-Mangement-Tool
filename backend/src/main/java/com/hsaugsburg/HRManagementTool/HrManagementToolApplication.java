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


	/**
	 * If this method is uncommented, the db will be filled with the user data below. So this should only be used when the db does not already
	 * have the below users.
	 * After initializing the db the method needs to be commented again.
	 * @param zugangsRepo
	 * @param encoder to encode the passwords
	 * @return
	 */
//	@Bean
//    CommandLineRunner commandLineRunner(ZugangsRepo zugangsRepo, PasswordEncoder encoder) {
//		return args -> {
//			zugangsRepo.save(new ZugangEntity("user@ma", encoder.encode("password"), "ROLE_USER"));
//			zugangsRepo.save(new ZugangEntity("admin@hr", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
//		};
//	}

}
