package com.example.tp_transactionnel_spring;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TpTransactionnelSpringApplication implements CommandLineRunner {

    @Autowired
    private ServiceLibrary serviceLibrary;


    public static void main(String[] args) {
        SpringApplication.run(TpTransactionnelSpringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("hello");
        System.out.println();

        Long book1id = serviceLibrary.saveBook("Les parapluies sont disparus", "Phil", "mouse",2004, 2, "manuel Scolaire");
        Long book2id = serviceLibrary.saveBook("Les parapluies sont presque Disparue", "Phil", "mouse",2004, 6, "manuel Scolaire");

        Long cd1id = serviceLibrary.saveCd("titrecd", "diego", "ubi",2007,0, "good game");
        System.out.println(serviceLibrary.getCd(cd1id));
    }
}
