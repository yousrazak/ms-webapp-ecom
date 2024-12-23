package org.sid.billingservice;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.sid.billingservice.services.CustomerRestClient;
import org.sid.billingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start (BillRepository billingRepository, ProductItemRepository productItemRepository,
                             CustomerRestClient customerRestClient,
                             ProductRestClient productRestClient){
        return args ->{
            Collection<Product> products=productRestClient.allProducts().getContent();
            Long customerId=1L;
            Customer customer=customerRestClient.findCustomerById(customerId);
            if(customer==null) throw new RuntimeException("Customer Not Found");
            Bill bill= new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerId(customerId);
            Bill savedBill=billingRepository.save(bill);
            products.forEach(p->{
                ProductItem productItem=new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductId(p.getId());
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt()*10);
                productItem.setDiscount(Math.random());
                productItemRepository.save(productItem);
            });


        };
    }
}
