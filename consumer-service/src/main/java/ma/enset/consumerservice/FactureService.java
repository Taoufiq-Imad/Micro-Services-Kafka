package ma.enset.consumerservice;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FactureService {
    private FactureRepository factureRepository;
    private FileWriter csvWriter;
    private String pathFile="factures.csv";

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
        try {
            csvWriter= new FileWriter(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Facture save(Facture facture){
        factureRepository.save(facture);
        return facture;
    }
    public List<Facture> getAll(){
        return factureRepository.findAll();
    }
    public void saveToCsv(Facture facture){

        try {
            csvWriter.append(fatcureToString(facture));
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String fatcureToString(Facture facture){
        return facture.getNumero()+","+facture.getNomClient()+","+facture.getMontant();
    }
}
