package ma.enset.producerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
    @Autowired
    private KafkaTemplate<Long, Facture> kafkaTemplate;

    @GetMapping("/test")
    public void send(){
        Facture facture=new Facture(1,"imad",Math.random()*10000);
        System.out.println("1  "+facture);
        kafkaTemplate.send("FACTURATION",facture.getNumero(),facture);
        System.out.println("2  "+facture);
    }
}
