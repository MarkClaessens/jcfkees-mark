/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeviewtable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slashy
 */
public class Categorie {
    private String name;
    private List<Food> foods;
    private List<Categorie> categorieen;
    
    public Categorie(String name)
    {
        this.name = name;
        foods = new ArrayList<>();
        categorieen = new ArrayList<>();              
    }
    
    public void addCategorie(Categorie categorie)
    {
        categorieen.add(categorie);
    }
    public void addfood(Food food)
    {
        foods.add(food);
    }
    public List<Categorie> getCategorie()
    {
        return categorieen;
    }
    public List<Food> getfood()
    {
        return foods;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
