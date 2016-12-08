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
public class Santa extends Thread {
    
    String name;
    String department;
    Sleigh sleigh;
    int num_presents_given = 0;
    float time_at_empty_sleigh = 0;
    
    Sack santaSack;
    Clock clock;
    
    
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
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException ex) {
                
            }
             System.out.println(clock.getTime());
            getPresents();
        }
            
        
        
    }
    
    
    private void getPresents()
    {
        
        
        Presents item = sleigh.removePresent();
          
        System.out.println("*************** " + name + " " + " " + item.type + " " + item.gender);          
         
        santaSack.AddToy(item);
        
           
        

        
    }
}
