package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}



	@Bean
	public CommandLineRunner loadData(AccountService service ) {
		return (args) -> {
			// save a couple of customers
			//repository.save(new Account("07.11.2018", "07.11.2018", "07.11.2018", "450€", "950€", "FI8000168542302", "25-445", "1289-8555", "Loan", "Ibrahim"));
			//repository.save(new Account("08.12.2018", "03.10.2019", "07.11.2018", "1450€", "950€", "FI8000168642302", "26-345", "5489-8555", "Palkka", "Mohamed"));
			//repository.save(new Account("08.12.2018", "03.10.2019", "07.11.2018", "1450€", "950€", "FI8000168642302", "26-345", "5489-8555", "Palkka", "Suleiman"));


			// fetch all customers
		/*	log.info("Customers found with findAll():");
			log.info("-------------------------------");
		for (Account account : service.findAll()) {
		log.info(account.toString());
	}
			log.info("");

	fetch an individual account by ID
	Account account = service.findById(1L);
		log.info("Accounts found with findOne(1L):");
		log.info("--------------------------------");
		log.info(account.toString());
		log.info("");*//*

	// fetch customers by last name
		log.info("Accounts found with findByReferenceNumberStartsWithIgnoreCase('easy'):");
		log.info("--------------------------------------------");
		for (Account easy : service
			.findByReferenceNumberStartsWithIgnoreCase("")) {
		log.info(easy.toString());
	}
		log.info("");*/
};
	}
}





	/*public CommandLineRunner loadData(AccountService upload) {
		return (args) -> {
			upload.save(new Account(" ", "good", "create", "missing", "effect", "load", "easy", "safe", "ignore", "save"));
			upload.save(new Account(" ", "beautiful", "build", "erasing", "locate", "lineup", "gotit", "warning", "translate", "remove"));
			service.save(new Account(" ", "food", "source", "waiting", "restaurant", "load", "specific", "ingredient", "wave", "shake"));

			// fetch all customers
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : service.findAll()) {
				log.info(account.toString());
			}
			log.info("");

			// fetch an individual account by ID
			Account account = service.findById(1L);
			log.info("Accounts found with findOne(1L):");
			log.info("--------------------------------");
			log.info(account.toString());
			log.info("");

			// fetch customers by last name
			log.info("Accounts found with findByReferenceNumberStartsWithIgnoreCase('easy'):");
			log.info("--------------------------------------------");
			for (Account easy : service
					.findByReferenceNumberStartsWithIgnoreCase("easy")) {
				log.info(easy.toString());
			}
			log.info("");
		};
	}*/




