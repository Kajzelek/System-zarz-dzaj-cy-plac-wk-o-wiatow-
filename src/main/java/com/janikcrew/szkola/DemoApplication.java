package com.janikcrew.szkola;

import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(OsobaDAO osobaDAO) {
		return runner -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			Admin admin = new Admin("68111094029", "Marek", "Idzik", "marekidzik@gmail.com", LocalDate.parse("1968-11-10", formatter));
			admin.setRola("ROLE_ADMIN");
			osobaDAO.save(admin);
		};
	}

}
