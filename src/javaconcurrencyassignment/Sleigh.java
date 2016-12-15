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
    public Semaphore spaces;
    private Semaphore presentsSem;
    
    private final int maxPresents = 120;
    private Presents[] presents;
    private int numPresents = 0;
    
    private int nextIn = 0;
    private int nextOut = 0;
    
  
  public Sleigh() {
        spaces = new Semaphore(maxPresents);
        presentsSem = new Semaphore(0);
        presents = new Presents[maxPresents];
  }
  
  public void  addPresent(Presents item) {
      
        try {
            spaces.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        presents[nextIn] = item;
        numPresents++;
        
        
        
        nextIn++;
        if(nextIn == presents.length){
            nextIn = 0;
        }
      
        presentsSem.release();
        mutex.release();
  }
  
  public Presents removePresent() {
        
        try {
            presentsSem.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
      
        Presents present;
        present = presents[nextOut];
        numPresents--;
        
       
        
        nextOut++;
        if (nextOut == presents.length) {
            nextOut=0;
        }
        
        spaces.release();
        mutex.release();
               
        return present;
  }
  
  public boolean sleighFull() {
      boolean full = true;
      
      try{
        mutex.acquire();  
        
        if(numPresents != maxPresents)
        {
            full = false;
        }
      } catch (InterruptedException ex) {
          ex.printStackTrace();
      }
      
      
      mutex.release();
      
      return full;
  }
  
  public boolean sleighEmpty() {
      boolean empty = false;
      
      try{
        mutex.acquire();  
        
        if(numPresents == 0)
        {
            empty = true;
        }
      } catch (InterruptedException ex) {
          ex.printStackTrace();
      }
      
      
      mutex.release();
      
      return empty;
  }
  
  public int getNumberPresents() {
     int num = 0;
      try{
        mutex.acquire();  
        
        num = numPresents;
      } catch (InterruptedException ex) {
          ex.printStackTrace();
      }
      
     mutex.release();
     return num;
  }
  
  public void report() {
      System.out.println("SLEIGH REPORT");
       System.out.println("Items left on sleigh: " + numPresents);
  }
    
}
