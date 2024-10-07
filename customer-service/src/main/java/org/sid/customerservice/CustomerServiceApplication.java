package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
										RepositoryRestConfiguration repositoryRestConfiguration){
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Customer.class);

            customerRepository.saveAll(
					List.of(
							Customer.builder().name("Customer 1").email("Customer1@gmail.com").build(),
							Customer.builder().name("Customer 2").email("Customer2@gmail.com").build(),
							Customer.builder().name("Customer 3").email("Customer3@gmail.com").build(),
							Customer.builder().name("Customer 4").email("Customer4@gmail.com").build(),
							Customer.builder().name("Customer 5").email("Customer5@gmail.com").build()
					)
			);
			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
        };
	}

}
