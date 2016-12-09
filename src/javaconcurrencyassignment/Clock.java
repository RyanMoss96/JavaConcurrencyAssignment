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
public class Clock extends Thread {
    
     private final int dayTime = 60 * 8;
     private boolean dayFinished = false;
     private int timer = 0;
     private final int tick = 10;
    
    public void Clock() {
        
    }
    
    public int getTime() {
        return timer;
    }
    
    public boolean dayOver() {
        return dayFinished;
    }
    
    public void run() {
        while(timer < dayTime) {
           
            timer++;
            try {
                Thread.sleep(tick);
                
            } catch (InterruptedException ex) {
            }
            
              
        }
        
        dayFinished = true;
    }
}
