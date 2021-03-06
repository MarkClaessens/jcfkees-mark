package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.AantalWoorden;
import woordenapplicatie.ConcordinatieWoorden;
import woordenapplicatie.FrequentieWoorden;
import woordenapplicatie.SorteerWoorden;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
         AantalWoorden aw = new AantalWoorden(taInput.getText());
         taOutput.setText("Totaal aantal woorden:\t\t\t" + aw.getAantalWoorden() + "\nAantal verschillende woorden:\t" + aw.getAantalVerschillendeWoorden());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {         
         SorteerWoorden SW = new SorteerWoorden(taInput.getText());
         Set<String> woordenlijst = SW.getSorteerVerschillendeWoorden();
         String nieuwtekst = "";
         for(String woord : woordenlijst)
         {
             System.out.println(woord);
             nieuwtekst = nieuwtekst + woord + "\n";
         }
         taOutput.setText(nieuwtekst);
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
         FrequentieWoorden fw = new FrequentieWoorden(taInput.getText());
         taOutput.setText(fw.telWoorden());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        taOutput.setText("");
        ConcordinatieWoorden CW = new ConcordinatieWoorden(taInput.getText());
        Map<String, Set<Integer>> woordregels = CW.getConcordantie();
        
        for (String key : woordregels.keySet()) 
        {
            String woord = key + ": [";
            for (int i : woordregels.get(key)) 
            {
                woord += String.valueOf(i) + ", ";
            }
            woord = woord.substring(0, woord.length() - 2);
            woord += "]\n";
            taOutput.appendText(woord);
        }
    } 
}
   

