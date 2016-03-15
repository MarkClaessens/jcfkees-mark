/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmannnn;

/**
 *
 * @author Mark
 */
public class Letter {
    private String letter;
    private int frequentie;
    
    public Letter(String letter)
    {
        this.letter = letter;
        frequentie = 1;
    }
    
    public void hoogopfreq()
    {
        frequentie++;
    }
    
    public String getletter()
    {
        return letter;
    }
    
    public int getfrequentie()
    {
        return frequentie;
    }
}

