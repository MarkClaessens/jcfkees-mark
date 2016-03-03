/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import static jdk.nashorn.internal.objects.NativeArray.map;

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
        Map<String, Integer> woordenMetAantal = new HashMap<String, Integer>();    
        
        for (String woord : woorden) {
            Integer woordValue = woordenMetAantal.get(woord);
            if(woordValue == null){
                woordenMetAantal.put(woord, 1); 
            }
            else{
                woordenMetAantal.put(woord, woordValue + 1); 
            }           
        }   
        
        Map<String, Integer> sorted_map = sortByValue(woordenMetAantal);
        
        String tekst = "";
        for (Entry<String, Integer> entry : sorted_map.entrySet()){
            tekst = tekst + entry.getKey() + ": " + entry.getValue() + "\n";
        }
       
        return tekst;
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
