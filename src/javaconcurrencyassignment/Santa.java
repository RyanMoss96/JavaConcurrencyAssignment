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
public class Santa extends Thread {
    
    private String name;
    private String department;
    private Sleigh sleigh;
    private int num_presents_given = 0;
    private float time_at_empty_sleigh = 0;
    private final int base_wait_time = 10;
    
    private Sack santaSack;
    private Clock clock;
    
    
    public Santa(String name, Sleigh sleigh, Clock clock) {
        this.name = name;
        //this.department = department;
        this.sleigh = sleigh;
        this.clock = clock;
        
        santaSack = new Sack();
    }
    public void run() {
        
        while(!clock.dayOver()) {
            
            
            try {
                sleep((int) (randInt() * base_wait_time));
            } catch (InterruptedException ex) {
                
            }
            
            System.out.println(clock.getTime());

            getPresents();
            
            givePresentsToChildren();
            
        
        }
            
        
        
    }
    
    
    private void getPresents()
    {
        
        
        Presents item = sleigh.removePresent();
          
        System.out.println("*************** " + name + " " + " " + item.type + " " + item.gender);          
         
        santaSack.AddToy(item);
        
    }
    
    private void givePresentsToChildren() {
        
        //Spending a random amount of time with each child
        //Base time is 10 and randInt() returns a number between 1 and 5.
        try {
            sleep((int) (randInt() * base_wait_time));
        } catch (InterruptedException ex) {
            
        }
    }
    
    
    private static int randInt() {
        
        Random rand = new Random();
        int randomNum = rand.nextInt((6 - 1));

        return randomNum;
    }
}
