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
    
    private Presents[] present = new Presents[10];
    private int number_of_presents = 0;
    
    public Sack()
    {
        
    }
    
    public void AddToy(String type, String gender)
    {
        present[number_of_presents].type = type;
        present[number_of_presents].gender = gender;
        
        number_of_presents++;
    }
    
    public String GetGender(int i){
        return present[i].gender;
    }
    
    public Presents GetPresent(int i)
    {
        return present[i];
    }
    
    public int NumberOfPresents() {
        return number_of_presents;
    }
   
}
