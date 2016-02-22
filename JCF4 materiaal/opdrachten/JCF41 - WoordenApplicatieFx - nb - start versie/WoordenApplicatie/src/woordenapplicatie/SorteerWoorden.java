/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Kees
 */
public class SorteerWoorden {
    
    private String[] woorden;
    
    public SorteerWoorden(String tekst){     
        tekst = tekst.toLowerCase();
        tekst = tekst.replaceAll(",", "");
        tekst = tekst.replaceAll("\n", " ");    
        this.woorden = tekst.split(" ");
    }
    
    
    
    public Set<String> getSorteerVerschillendeWoorden(){
        Set<String> verschillendeWoorden = new TreeSet<String>(Collections.reverseOrder());
        for (String woord : woorden) {
            verschillendeWoorden.add(woord); 
        }
        return verschillendeWoorden;
    }
}
