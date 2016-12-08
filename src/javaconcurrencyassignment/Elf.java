/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrencyassignment;


import java.util.Random;
/**
 *
 * @author ryanmoss
 */
public class Elf extends Thread {
    
    String name;
    int total_presents_wrapped = 0;
    float time_at_sleigh = 0;
    Sleigh sleigh;
    Presents present;
   
    String[] present_types =  {"train", "doll", "dinosaur", "whistle", "fake tattoo", "bracelet"};
    String[] present_genders = {"Boy", "Girl"};
    
    public Elf(String name, Sleigh sleigh) {
        this.name = name;
        this.sleigh = sleigh;
        
        present = new Presents();
    }
    
   
    
    public void run() {
        for (int i=0; i < 5; i++){
            try {
                sleep((int) (Math.random() * 5));
            } catch (InterruptedException ex) {
            }
             createPresent();
             
            
        }
       
    }
    
     private void createPresent() {
        present.type = selectPresent();
        present.gender = selectGender();
       
        try {
            sleep((int) (Math.random() * 5));
        } catch (InterruptedException ex) {
            
        }
        
        present.wrapped = true;
        total_presents_wrapped++;
        
        
        
        
        
            sleigh.addPresent(present);
            
            System.out.println(name + " " + " " + present.type + " " + present.gender);
            
        
        
    }
     
     private String selectPresent() {
        int random = randInt(0, 6);
         
        return present_types[random];
     }
     
     private String selectGender() {
         int random = randInt(0,2);
         
         return present_genders[random];
     }
     
     private static int randInt(int min, int max) {
        
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min));

        return randomNum;
}
}
