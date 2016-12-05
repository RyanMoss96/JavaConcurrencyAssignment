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
public class Sleigh {
    
  private Presents[] presents = new Presents[10];
  private int numPresents = 0;
  private final int maxPresents = 10;
  
  public Sleigh() {
      
  }
  
  private void addPresent(Presents item) {
        presents[numPresents] = item;
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
        }
        numPresents++;
        
  }
  
  private void removePresent() {
      
  }
  
  public void checkSleighSpace(Presents item) {
      
      if(numPresents == maxPresents){
          
      } else {
        addPresent(item);  
      }
      
  }
  
  public void checkPresentsExist() {
      removePresent();
      
  }
    
}
