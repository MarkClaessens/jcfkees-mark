/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Kees
 */    
public class ConcordinatieWoorden {
    
    private String tekst;
    private Map<String, Set<Integer>> woordregels; 
    public ConcordinatieWoorden(String tekst)
    {      
       this.tekst = tekst; 
       this.tekst = tekst.toLowerCase();
       this.tekst = tekst.replaceAll(",", "");
       this.tekst = tekst.replaceAll("\n", " ");
       this.tekst = tekst.replaceAll("é", "e");
    }
    
    public Map<String, Set<Integer>> getConcordantie()
    {
        woordregels = new HashMap<>();
        int regel = 1;
        for (String woord : tekst.split(" ")) 
        {
            if (woord.contains("\n")) {
                regel++;
                woord = woord.replace("\n", "");
            }
            if (woordregels.containsKey(woord)) 
            {
                woordregels.get(woord).add(regel);
            } 
            else 
            {
                Set<Integer> regellijst = new HashSet<>();
                regellijst.add(regel);
                woordregels.put(woord, regellijst);
            }            
        }
        return woordregels;
    }
}

