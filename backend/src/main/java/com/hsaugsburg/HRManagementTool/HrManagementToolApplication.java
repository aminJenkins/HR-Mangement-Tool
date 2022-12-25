package com.hsaugsburg.HRManagementTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
//	CommandLineRunner commandLineRunner(ZugangsRepo zugangsRepo, PasswordEncoder encoder) {
//		return args -> {
//			zugangsRepo.save(new Zugang("user@ma", encoder.encode("password"), "ROLE_USER"));
//			zugangsRepo.save(new Zugang("admin@hr", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
//		};
//	}

}
