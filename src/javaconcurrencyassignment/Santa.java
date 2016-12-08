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
    
    
    public Santa(String name, String department, Sleigh sleigh) {
        this.name = name;
        this.department = department;
        this.sleigh = sleigh;
        
        santaSack = new Sack();
    }
    public void run() {
        
        for (int i=0; i < 5; i++){
            try {
                sleep((int) (Math.random() * 5));
            } catch (InterruptedException ex) {
            }
             
            getPresents();
        }
        
    }
    
    
    private void getPresents()
    {
        
        
        Presents item = sleigh.removePresent();
          
        System.out.println(name + " " + " " + item.type + " " + item.gender);          
         
        santaSack.AddToy(item);
        
           
        

        
    }
}
