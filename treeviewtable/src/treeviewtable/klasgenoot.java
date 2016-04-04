/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeviewtable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Slashy
 */
public class klasgenoot {
    
    private SimpleStringProperty naam;
    private SimpleStringProperty klas;
    private SimpleStringProperty richting;
    
    public klasgenoot(String name, String clas, String Richting)
    {
        this.naam = new SimpleStringProperty(name);
        this.klas = new SimpleStringProperty(clas);
        this.richting = new SimpleStringProperty(Richting);       
    }
    
    public String getnaam() {
            return naam.get();
        }
 
        public void setnaam(String fName) {
            naam.set(fName);
        }
 
        public String getklas() {
            return klas.get();
        }
 
        public void setklas(String fName) {
            klas.set(fName);
        }
 
        public String getrichting() {
            return richting.get();
        }
 
        public void setrichting(String fName) {
            richting.set(fName);
        }
        
        public StringProperty naamProperty() {
        return naam;
    }
        public StringProperty klasProperty() {
        return klas;
    }
        public StringProperty richtingProperty() {
        return richting;
    }
}
