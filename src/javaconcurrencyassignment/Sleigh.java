/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrencyassignment;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ryanmoss
 */
public class Sleigh {
    
    private Semaphore mutex = new Semaphore(1);
    private Semaphore spaces;
    private Semaphore presentsSem;
    
    private final int maxPresents = 10;
    private Presents[] presents;
    
    private int nextIn = 0;
    private int nextOut = 0;
    
  
  public Sleigh() {
        spaces = new Semaphore(maxPresents);
        presentsSem = new Semaphore(0);
        presents = new Presents[maxPresents];
  }
  
  private void addPresent(Presents item) {
      
      
        
        presents[nextIn] = item;
        
        System.out.println(presents[nextIn].type);
        System.out.println(presents[nextIn].gender);
        System.out.println(presents[nextIn].wrapped);
        System.out.println(" ");
       
        
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        
      nextIn++;
        if(nextIn == maxPresents){
            nextIn = 0;
        }
      
        
        
  }
  
  private Presents removePresent() {
        
      
      
        Presents present;
        present = presents[nextOut];
        System.out.println( present.type);
        presents[nextOut] = null;
        
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        
        nextOut++;
        if (nextOut== maxPresents)
            nextOut=0;
        
               
        
        System.out.println(" ");
        return present;
  }
  
  public void checkSleighSpace(Presents item, String name) {
      
      try {
            spaces.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
          
        System.out.println(name);
        addPresent(item);  
      
        presentsSem.release();
        mutex.release();
  }
  
  public Presents checkPresentsExist(String name) {
      
      try {
            presentsSem.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(name);
        Presents item = removePresent();
        spaces.release();
        mutex.release();
        return item;
              
      
  }
    
}
