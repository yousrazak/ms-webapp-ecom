package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration repositoryRestConfiguration) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer( 0,"Hassan", "hassan@mail.com"));
            customerRepository.save(new Customer( 0,"Mohamed", "mohamed@mail.com"));
            customerRepository.save(new Customer( 0,"Ali", "ali@mail.com"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
