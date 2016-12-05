/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrencyassignment;

/**
 *
 * @author ryanmoss
 */
public class Sack {
    
    public enum Colour {
        Blue, Pink
    }
    
    
    private String toy_type;
    private Colour paper_colour;
    
    
    public Sack()
    {
        
    }
    
    public void AddToy(String toy_type, Colour paper_colour)
    {
        this.toy_type = toy_type;
        this.paper_colour = paper_colour;
    }
}
