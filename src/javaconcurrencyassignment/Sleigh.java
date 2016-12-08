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
    
    private final int maxPresents = 25;
    private Presents[] presents = new Presents[maxPresents];
    private int numPresents = 0;
    private int nextIn = 0;
    private int nextOut = 0;
    
  
  public Sleigh() {
        spaces = new Semaphore(maxPresents);
        presentsSem = new Semaphore(0);
  }
  
  private void addPresent(Presents item) {
      
      
        
        presents[nextIn] = item;
        
        
        
        numPresents++;
        
        System.out.println(numPresents);
       
        System.out.println(presents[nextIn].type);
        System.out.println(presents[nextIn].gender);
        System.out.println(presents[nextIn].wrapped);
        System.out.println(" ");
        
        
      nextIn++;
        if(nextIn == presents.length){
            nextIn = 0;
        }
      
        
        
  }
  
  private Presents removePresent() {
        
      
      
        Presents present;
        present = presents[nextOut];
        System.out.println( presents[nextOut].type);
        presents[nextOut] = null;
        
        
        
        nextOut++;
        if (nextOut==presents.length)
            nextOut=0;
        
        numPresents--;
       
        System.out.println(numPresents);
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
