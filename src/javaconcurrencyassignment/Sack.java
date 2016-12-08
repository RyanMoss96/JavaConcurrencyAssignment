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
    
    private int maxPresents = 10;
    private Presents[] presents = new Presents[maxPresents];
    private int number_of_presents = 0;
    private int nextIn = 0;
    
    public Sack()
    {
        
    }
    
    public void AddToy(Presents present)
    {
        presents[nextIn] = present;
       
        nextIn++;
        if(nextIn == presents.length){
            nextIn = 0;
        }
        
        number_of_presents++;
    }
    
    public String GetGender(int i){
        return presents[i].gender;
    }
    
    public Presents GetPresent(int i)
    {
        return presents[i];
    }
    
    public int NumberOfPresents() {
        return number_of_presents;
    }
   
}
