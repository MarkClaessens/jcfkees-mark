/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

/**
 *
 * @author Kees
 */
public class FrequentieWoorden {
    
    private String[] woorden;
    
    public FrequentieWoorden(String tekst){     
        tekst = tekst.toLowerCase();
        tekst = tekst.replaceAll(",", "");
        tekst = tekst.replaceAll("\n", " ");    
        this.woorden = tekst.split(" ");
    }
    
    public String telWoorden(){
        return null;
    }
}
