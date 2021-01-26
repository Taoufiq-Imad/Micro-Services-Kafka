package ma.enset.producerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.Arrays; import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Component
public class FactureProducer implements ApplicationRunner {
    private KafkaTemplate<Long, Facture> kafkaTemplate;
    @Autowired
    public FactureProducer(KafkaTemplate<Long, Facture> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private long factureNumber=0L;
    @Override
    public void run(ApplicationArguments applicationArguments) {
        List<String> clients= Arrays.asList("Hassan","Mohamed","Hanane","Yassine","Samir","Aziz");
        Runnable runnable=()->{
            String client=clients.get(new Random().nextInt(clients.size()));
            Facture facture=new Facture(++factureNumber,client,Math.random()*10000);
            kafkaTemplate.send("FACTURATION",facture.getNumero(),facture);
            System.out.println("2  "+facture);
        };
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable,1,1, TimeUnit.SECONDS);

    }
}
