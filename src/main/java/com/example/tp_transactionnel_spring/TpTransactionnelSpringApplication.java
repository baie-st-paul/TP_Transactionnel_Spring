package com.example.tp_transactionnel_spring;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpTransactionnelSpringApplication implements CommandLineRunner {


    private final ServiceLibrary serviceLibrary;

    public TpTransactionnelSpringApplication(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
    }


    public static void main(String[] args) {
        SpringApplication.run(TpTransactionnelSpringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("hello");
        System.out.println();

        long book1id = serviceLibrary.saveBook("Les parapluies sont disparus", "Phil", "mouse",2004, 2, "manuel Scolaire");
        long book2id = serviceLibrary.saveBook("Les parapluies sont presque Disparue", "Phil", "mouse",2004, 6, "manuel Scolaire");
        long book3id = serviceLibrary.saveBook("Les parapluies sont disparus", "Phil", "mouse",2004, 2, "manuel Scolaire");

        long cd1id = serviceLibrary.saveCd("titrecd", "diego", "ubi",2007,0, "good game");

        long dvd1id = serviceLibrary.saveDvd("titredvd", "pewdiepie", "disney",2006, 0, "good movie");

        long client1Id = serviceLibrary.saveClient("phil", "vall", "add", "email", "bjd dri");



        long loanId1 = serviceLibrary.loanBookToCLient(book1id,client1Id);

        long loanId2 = serviceLibrary.loanCdToClient(cd1id, client1Id);

        long loanId3 = serviceLibrary.loanDvdToClient(dvd1id, client1Id);


    }
}
