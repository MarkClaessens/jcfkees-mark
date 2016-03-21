/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Slashy
 */
public class Huffman {
    
    public static Map<String, String> huffmanWaardes = new HashMap<String, String>();
    public static ArrayList<String> allCodes = new ArrayList<String>();
    
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(List<Integer> charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.size(); i++)
            if (charFreqs.get(i) > 0)
                trees.offer(new HuffmanLeaf(charFreqs.get(i), test2[i]+""));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
            huffmanWaardes.put(leaf.value, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    
    public static void generateHuffmanCode(String tekst){
        int i = 0;
        String finalTekst = "";
        while(i < tekst.length()){
               System.out.println(tekst.substring(i, i + 1));
               finalTekst += huffmanWaardes.get(tekst.substring(i, i + 1));
               System.out.println(finalTekst);
               i++;
        } 
    }
    
    public static void decodeHuffmanCode(String code){
        int i = 0;
        String finalTekst = "";
        while(!code.equals("")){
            for (String stukjeCode : allCodes){
                try{
                   if (stukjeCode.equals(code.substring(0, stukjeCode.length()))){
                       finalTekst += getKeyFromValue(stukjeCode);
                       System.out.println(finalTekst);
                       code = code.substring(stukjeCode.length());
                   }
                }
                catch(Exception e) { }
            }   
        }  
    }
    
    public static String getKeyFromValue(Object value) {
        for (String o : huffmanWaardes.keySet()) {
          if (huffmanWaardes.get(o).equals(value)) {
            return o;
          }
        }
        return null;
    }

    public static void main(String[] args) {       
        String tekst = "Henkie bedenkie";
        Frequentie frq = new Frequentie(tekst);  
        String letters = "";        
        List<Integer> cijfers = new ArrayList(frq.telWoorden().values());
        for (Map.Entry<String, Integer> entry : frq.telWoorden().entrySet())
        {
            letters = letters + entry.getKey();            
            tekst = tekst + entry.getKey() + ": " + entry.getValue() + "\n";
        }        
        char[] test2 = letters.toCharArray();

        // build tree
        HuffmanTree tree = buildTree(cijfers,test2);

        // print out results
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
        
        //Generate new code
        System.out.println("\n\nGenerate HuffmanCode:");
        generateHuffmanCode("Hek");
        System.out.println("\nGenerate HuffmanCode:");
        generateHuffmanCode("Henkie bedenkie");
        
        allCodes.addAll(huffmanWaardes.values());
               
        //Decoding HuffmanCode
        System.out.println("\n\nDecode HuffmanCode: 101011011100010110000011110111101110001011");
        decodeHuffmanCode("101011011100010110000011110111101110001011");
    }
}
