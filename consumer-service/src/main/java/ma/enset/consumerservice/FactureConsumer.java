package ma.enset.consumerservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FactureConsumer {
    private FactureService factureService;

    public FactureConsumer(FactureService factureService) {
        this.factureService = factureService;
    }

    @KafkaListener(topics = "FACTURATION",groupId = "sample_consumer")
    public void onMessage(Facture facture){
        factureService.save(facture);
        factureService.saveToCsv(facture);
    }
}
