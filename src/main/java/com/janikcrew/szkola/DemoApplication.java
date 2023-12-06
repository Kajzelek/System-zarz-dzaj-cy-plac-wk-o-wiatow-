package com.janikcrew.szkola;

import com.janikcrew.szkola.dao.BudzetDAO;
import com.janikcrew.szkola.dao.BudzetDAOImpl;
import com.janikcrew.szkola.dao.KlasaDAO;
import com.janikcrew.szkola.dao.OsobaDAO;
import com.janikcrew.szkola.entity.*;
import com.janikcrew.szkola.service.*;
import jakarta.persistence.EntityManager;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public CommandLineRunner commandLineRunner(BudzetService budzetService, OsobaService osobaService,
											   KlasaService klasaService, PrzedmiotService przedmiotService,
											   WiadomoscService wiadomoscService, UwagaService uwagaService,
											   AdminService adminService, GodzinaLekcyjnaService godzinaLekcyjnaService,
											   MiejsceService miejsceService, DyzurService dyzurService) {
		return runner -> {
			//utworzOsobe(osobaService);
			//testTransakcji(budzetService);
			//testUtworzeniaNauczyciela(budzetService, osobaService);
			//testUtworzeniaKlasy(osobaService, klasaService);
			//testUtworzeniaUcznia(osobaService, klasaService);
			//testDodaniaUczniaDoKlasy(klasaService, osobaService);
			//testUtworzeniaPrzedmiotu(przedmiotService, klasaService, osobaService);
			//testUsunieciaPrzedmiotu(przedmiotService);
			//testDzialaniaKlasy(przedmiotService, osobaService, klasaService);
			//testUtworzeniaWiadomosci(wiadomoscService, osobaService);
			//utworzUwage(uwagaService, osobaService);
			//testUtworzeniaKalendarza(adminService);
			//testUsunieciaKalendarza(adminService);
			//testUtworzeniaGodzinyLekcyjnej(godzinaLekcyjnaService, osobaService, przedmiotService, klasaService, miejsceService);
			//testUsunieciaGodzinyLekcyjnej(godzinaLekcyjnaService);
			//testDodaniaZastepstwa(godzinaLekcyjnaService, osobaService);
			//testDodaniaZastepujacejSali(miejsceService, godzinaLekcyjnaService);
			//testDodaniaZdarzenia(godzinaLekcyjnaService);
			//testDodaniaMiejsca(miejsceService);
			//testModyfikacjiNazwySali(miejsceService);
			testUtworzeniaDyzuru(dyzurService);

		};
	}

	private void testUtworzeniaDyzuru(DyzurService dyzurService) {
	}

	private void testUsunieciaKalendarza(AdminService adminService) {
		adminService.wyczyscKalendarz();
	}

	private void testDodaniaZastepujacejSali(MiejsceService miejsceService, GodzinaLekcyjnaService godzinaLekcyjnaService) {
		int idGodzinyLekcyjnej = 15;
		int idSaliZastepujacej = 5;
		godzinaLekcyjnaService.dodajZastepujacaSale(idGodzinyLekcyjnej, idSaliZastepujacej);
	}

	private void testModyfikacjiNazwySali(MiejsceService miejsceService) {
		String staraNazwa = "Sala Gimnastyczna nr 21";
		String nowaNazwa = "Sala gimnastyczna nr 21";
		miejsceService.aktualizujMiejsce(staraNazwa, nowaNazwa);
	}

	private void testDodaniaMiejsca(MiejsceService miejsceService) {
		String miejsce = "Sala nr 1";
 		miejsceService.dodajMiejsce(miejsce);
	}

	private void testUsunieciaGodzinyLekcyjnej(GodzinaLekcyjnaService godzinaLekcyjnaService) {
		int idPrzedmiotu = 3;
		godzinaLekcyjnaService.usunGodzineZPlanuByIdPrzedmiotu(idPrzedmiotu);
	}

	private void testDodaniaZdarzenia(GodzinaLekcyjnaService godzinaLekcyjnaService) {
		String zdarzenie = "Klasowe wyjście do kina";
		godzinaLekcyjnaService.dodajZdarzenieDoGodzinyLekcyjnej(16, zdarzenie);
	}

	private void testDodaniaZastepstwa(GodzinaLekcyjnaService godzinaLekcyjnaService, OsobaService osobaService) {
		godzinaLekcyjnaService.dodajZastepstwoDoGodzinyLekcyjnej(16, 2);
	}

	private void testUtworzeniaGodzinyLekcyjnej(GodzinaLekcyjnaService godzinaLekcyjnaService, OsobaService osobaService, PrzedmiotService przedmiotService, KlasaService klasaService, MiejsceService miejsceService) {
		Nauczyciel nauczyciel = (Nauczyciel) osobaService.findOsobaById(7);
		Przedmiot przedmiot = przedmiotService.findPrzedmiotById(3);
		Klasa klasa = klasaService.findKlasaByName("1a");
		Miejsce miejsce = miejsceService.findMiejsceById(1);
		String dzien = "poniedziałek";
		String godzRozpoczecia = "08:00:00";
		String dataRozpoczecia = "2023-09-04";
		godzinaLekcyjnaService.dodajGodzinaLekcyjnaDoPlanuLekcji(przedmiot, klasa, miejsce, dzien, godzRozpoczecia, dataRozpoczecia);
	}

	private void testUtworzeniaKalendarza(AdminService adminService) {
		adminService.utworzKalendarzNaRokSzkolny();
	}

	private void utworzUwage(UwagaService uwagaService, OsobaService osobaService) {
		Nauczyciel nauczyciel = (Nauczyciel) osobaService.findOsobaById(7);
		Uczen uczen = (Uczen) osobaService.findOsobaById(9);
		Uwaga uwaga = new Uwaga("NEGATYWNA", "Przeklinanie", "Łukasz przeklinał na lekcji niemieckiego");
		uwagaService.utworzUwage(uwaga, nauczyciel, uczen);
	}


	private void testUtworzeniaWiadomosci(WiadomoscService wiadomoscService, OsobaService osobaService) {
		Admin admin = (Admin) osobaService.findOsobaById(1);
		Nauczyciel nauczyciel = (Nauczyciel) osobaService.findOsobaById(2);
		Wiadomosc wiadomosc = new Wiadomosc("Szanowny Dyrektorze! ", "Dziękuję za przyjęcie do pracy! ");
		wiadomoscService.utworzWiadomosc(wiadomosc, nauczyciel, admin);
	}

	private void testUsunieciaPrzedmiotu(PrzedmiotService przedmiotService) {
		int id = 2;
		przedmiotService.deletePrzedmiotById(id);
	}

	private void testDzialaniaKlasy(PrzedmiotService przedmiotService, OsobaService osobaService, KlasaService klasaService) {
		Klasa klasa = klasaService.findKlasaByName("1a");
		for(Przedmiot przedmiot : klasa.getListaPrzedmiotow()) {
			System.out.println(przedmiot.getNazwa());
		}
	}


	private void testUtworzeniaPrzedmiotu(PrzedmiotService przedmiotService, KlasaService klasaService, OsobaService osobaService) {
		Przedmiot przedmiot = new Przedmiot("język niemiecki");
		String nazwaKlasy = "1a";
		int idNauczyciela = 7;
		Klasa klasa = klasaService.findKlasaByName(nazwaKlasy);
		Nauczyciel nauczyciel = (Nauczyciel) osobaService.findOsobaById(idNauczyciela);

		przedmiotService.dodajPrzedmiot(przedmiot, nauczyciel, klasa);

	}
	private void testDodaniaUczniaDoKlasy(KlasaService klasaService, OsobaService osobaService) {
		int id = 3;
		int id1 = 6;
		String name = "1a";
		Klasa klasa = klasaService.findKlasaByName(name);
		Uczen uczen = (Uczen) osobaService.findOsobaById(id);
		Uczen uczen1 = (Uczen) osobaService.findOsobaById(id1);
		klasaService.dodajUcznia(klasa, uczen, uczen1);


	}
	private void utworzOsobe(OsobaService osobaService) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Uczen uczen = new Uczen("02256745432", "Kacper", "Łukawski", "klukawski45@gmail.com", LocalDate.parse("2002-12-12"));
		Rodzic rodzic = new Rodzic("694785655678", "Maria", "Łukawska", "gorzowianka32@onet.pl", LocalDate.parse("1969-04-24", formatter));
		osobaService.dodajRodzicaUcznia(rodzic, uczen);
	}

	private void testUtworzeniaUcznia(OsobaService osobaService, KlasaService klasaService) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Uczen uczen = new Uczen("02222787564", "Łukasz", "Królicki", "lukupuku123@puk.pl", LocalDate.parse("2002-02-27", formatter));
		Rodzic rodzic = new Rodzic("68983746738", "Grażyna", "Królicka", "grazkrol@onet.pl", LocalDate.parse("1968-11-23", formatter));
		Klasa klasa = klasaService.findKlasaByName("1a");
		osobaService.dodajRodzicaUcznia(rodzic, uczen);
		klasaService.dodajUcznia(klasa, uczen);

	}

	private void testUtworzeniaKlasy(OsobaService osobaService, KlasaService klasaService) {
		int id = 2;

		Nauczyciel nauczyciel = (Nauczyciel) osobaService.findOsobaById(id);
		Klasa klasa = new Klasa("1a");
		klasaService.dodajKlase(klasa, nauczyciel);
	}

	private void testUtworzeniaNauczyciela(BudzetService budzetService, OsobaService osobaService) {

		int id = 2;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//osobaService.dodajUzytkownika(nauczyciel);
		osobaService.dodajNauczyciela(new Nauczyciel("57829485748", "Donald", "Tusk", "donald57@gmail.com", LocalDate.parse("1957-06-06", formatter)));
	}

	public void testTransakcji(BudzetService budzetService) throws Exception {
		int id = 1;
		Budzet budzet = budzetService.findBudzetById(id);
		//Transakcja transakcja = new Transakcja("WYDATEK", 20000.0, LocalDate.now(), LocalTime.now(), "Malowanie pomieszczeń");
		//budzetService.dodajTransakcjeDoBudzetu(budzet, transakcja);
		budzetService.znajdzListeTransakcjiBudzetu(budzet);

		for(Transakcja transakcja : budzet.getListaTransakcji())
			System.out.println(transakcja);


	}
}
