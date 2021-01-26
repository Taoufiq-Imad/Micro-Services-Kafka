package ma.enset.producerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture implements Serializable {
    private long numero;
    private String nomClient;
    private double montant;
}
