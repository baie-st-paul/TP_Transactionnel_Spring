package com.example.tp_transactionnel_spring;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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

        long book1id = serviceLibrary.saveBook("Les parapluies sont disparus", "Phil", "mouse",2004, 2, "manuel Scolaire");
        long book2id = serviceLibrary.saveBook("Les parapluies sont presque Disparue", "Phil", "mouse",2004, 6, "manuel Scolaire");
        long book3id = serviceLibrary.saveBook("Les parapluies sont disparus", "Phil", "mouse",2004, 2, "manuel Scolaire");

        long cd1id = serviceLibrary.saveCd("titrecd", "diego", "ubi",2007,0, "good game");

        long dvd1id = serviceLibrary.saveDvd("titredvd", "pewdiepie", "disney",2006, 0, "good movie");

        long client1Id = serviceLibrary.createClient("phil", "vall", "add", "email", "bjd dri");

        long loanId1 = serviceLibrary.loanBookToCLient(book1id,client1Id);

        long loanId2 = serviceLibrary.loanCdToClient(cd1id, client1Id);

        long loanId3 = serviceLibrary.loanDvdToClient(dvd1id, client1Id);

        serviceLibrary.returnBookFromClient(loanId1);
        serviceLibrary.returnCdFromClient(loanId2);
        serviceLibrary.returnDvdFromClient(loanId3);

        System.out.println(serviceLibrary.getClient(client1Id));
        System.out.println(serviceLibrary.getBook(book1id));
        System.out.println(serviceLibrary.getCd(cd1id));
        System.out.println(serviceLibrary.getDvd(dvd1id));

    }
}
