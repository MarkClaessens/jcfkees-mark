/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @author Kees
 */
public class Frequentie {
    
    private String zin;
    
    public Frequentie(String tekst){     
        this.zin = tekst.replaceAll(" ", "");
    }
    
    public Map<String, Integer> telWoorden(){
        Map<String, Integer> woordenMetAantal = new HashMap<String, Integer>();    
        int i = 0;
        while(i < zin.length()){
            String letter = zin.substring(i, i+1);
            Integer woordValue = woordenMetAantal.get(letter);
            if(woordValue == null){
                woordenMetAantal.put(letter, 1); 
            }
            else{
                woordenMetAantal.put(letter, woordValue + 1); 
            } 
            i++;
        }   
        
        Map<String, Integer> sorted_map = sortByValue(woordenMetAantal);
        
        String tekst = "";
        for (Entry<String, Integer> entry : sorted_map.entrySet()){
            tekst = tekst + entry.getKey() + ": " + entry.getValue() + "\n";
        }
       
        return sorted_map;
    }
  
    public static <K, V extends Comparable<? super V>> Map<K, V> 
        sortByValue( Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
            new LinkedList<Map.Entry<K, V>>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }
}
