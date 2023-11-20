package com.janikcrew.szkola;

import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.Admin;
import com.janikcrew.szkola.entity.Budzet;
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
			createAdmin(osobaDAO);


			//Zmiana1
		};
	}
	public void createAdmin(OsobaDAO osobaDAO) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Budzet budzetSzkoly = new Budzet(10000.0);
		Admin admin = new Admin("68111094029", "Marek", "Idzik", "marekidzik@gmail.com", LocalDate.parse("1968-11-10", formatter));
		admin.setRola("ROLE_ADMIN");
		admin.setBudzet(budzetSzkoly);
		osobaDAO.save(admin);

	}
}
