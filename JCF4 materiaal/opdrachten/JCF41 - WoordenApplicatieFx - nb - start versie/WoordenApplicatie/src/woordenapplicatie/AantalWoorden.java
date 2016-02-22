/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kees
 */
public class AantalWoorden {
    
    private String[] woorden;
    
    public AantalWoorden(String tekst){     
        tekst = tekst.toLowerCase();
        tekst = tekst.replaceAll(",", "");
        tekst = tekst.replaceAll("\n", " ");    
        this.woorden = tekst.split(" ");
    }
    
    public int getAantalWoorden(){      
        return woorden.length;
    }
    
    public int getAantalVerschillendeWoorden(){
        Set<String> verschillendeWoorden = new HashSet<String>();
        for (String woord : woorden) {
            verschillendeWoorden.add(woord); 
        }
        return verschillendeWoorden.size();
    }
}
