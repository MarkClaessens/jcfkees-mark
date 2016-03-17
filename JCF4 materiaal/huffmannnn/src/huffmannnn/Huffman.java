/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Slashy
 */
public class Huffman {
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(List<Integer> charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.size(); i++)
            if (charFreqs.get(i) > 0)
                trees.offer(new HuffmanLeaf(charFreqs.get(i), test2[i]));

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
        //Frequency (of the symbols above):
        int[] charFreqs = {1,1,2,2,2,2,2,2,2,3,3,3,4,4,4,5,7,9,18};


        // build tree
        HuffmanTree tree = buildTree(cijfers,test2);

        // print out results
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
}
