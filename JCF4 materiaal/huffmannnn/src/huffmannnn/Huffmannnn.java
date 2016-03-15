/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark
 */
public class Huffmannnn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tekst = "Kees heeft een fiets";
        Frequentie frq = new Frequentie(tekst);
        System.out.println(frq.telWoorden());
        /*
        int i = 0;
        List<Letter> letters = new ArrayList<>();
        while(i < tekst.length())
        {
          boolean bestaat = false;
          Letter letter = new Letter(tekst.substring(i, i + 1));
          for(Letter l : letters)
          {
              if(l.getletter().equals(letter.getletter()))
              {
                 bestaat = true;
                 l.hoogopfreq();
              }
          }
          if(!bestaat)
          {
              letters.add(letter); 
          }          
          i++;
        }
        for(Letter l : letters)
        {
            System.out.println(l.getletter() + ", " + l.getfrequentie());
        }*/
    }
    
}
