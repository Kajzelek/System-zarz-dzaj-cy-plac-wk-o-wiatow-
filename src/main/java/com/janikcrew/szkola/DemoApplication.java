package com.janikcrew.szkola;

import com.janikcrew.szkola.dao.BudzetDAO;
import com.janikcrew.szkola.dao.BudzetDAOImpl;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.Admin;
import com.janikcrew.szkola.entity.Budzet;
import com.janikcrew.szkola.entity.Transakcja;
import com.janikcrew.szkola.service.BudzetService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(BudzetService budzetService, BudzetDAO budzetDAO) {
		return runner -> {
			testTransakcji(budzetService, budzetDAO);
			//testUsunieciaTransakcji(budzetService);


			//Zmiana1
		};
	}

	private void testUsunieciaTransakcji(OsobaDAO osobaDAO, BudzetDAO budzetDAO) {
	}

	public void testTransakcji(BudzetService budzetService, BudzetDAO budzetDAO) throws Exception {
		int id = 1;
		Budzet budzet = budzetDAO.findBudzetById(id);
		Transakcja transakcja = new Transakcja("PRZYCHÓD", 500000.0, LocalDate.now(), LocalTime.now(), "Dofinansowanie z budżetu państwa");
		//budzetService.dodajTransakcjeDoBudzetu(budzet, transakcja);
		List<Transakcja> listaTransakcji = budzetDAO.findTransactionsByBudzetId(id);
		budzet.setListaTransakcji(listaTransakcji);
		transakcja.setBudzet(budzet);
		budzet.dodajTransakcje(transakcja);
		budzetDAO.update(budzet);
	}
}
