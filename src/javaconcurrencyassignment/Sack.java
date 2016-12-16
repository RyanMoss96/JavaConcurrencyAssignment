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
    private int nextOut = 0;
    
    public Sack() {
        
    }
    
    public void addToy(Presents present) {
        
       
            presents[nextIn] = present;
       
            nextIn++;
            if(nextIn == presents.length){
                nextIn = 0;
            }
        
            number_of_presents++;
    }
    
    public String getGender(int i){
        return presents[i].gender;
    }
    
    public Presents removeToy(String gender) {
        
        Presents present;
        present = presents[nextOut];
        
        nextOut++;
        number_of_presents--;
        if (nextOut == presents.length) {
            nextOut=0;
        }
        
        return present;
    } 
        
    public int numberOfPresents() {
        return number_of_presents;
    }
    
    public int maxPresents() {
        return maxPresents;
    }
    
    public boolean isEmpty() {
        return number_of_presents == 0;
    }
   
}
