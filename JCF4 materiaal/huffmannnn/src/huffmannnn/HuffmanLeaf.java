/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

/**
 *
 * @author Slashy
 */
class HuffmanLeaf extends HuffmanTree {
    public final String value; // the character this leaf represents

    public HuffmanLeaf(int freq, String val) {
        super(freq);
        value = val;
    }
}
