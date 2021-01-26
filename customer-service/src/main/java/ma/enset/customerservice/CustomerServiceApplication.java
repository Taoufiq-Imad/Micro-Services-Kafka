package ma.enset.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"imad","imad@imad.ma"));
            customerRepository.save(new Customer(null,"fatima","fatima@imad.ma"));
            customerRepository.save(new Customer(null,"oumayma","oumayma@imad.ma"));
            customerRepository.save(new Customer(null,"mohamed","mohamed@imad.ma"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
