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
public class JavaConcurrencyAssignment {

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Clock clock = new Clock();
        Sleigh sleigh = new Sleigh();
         
        Elf e1 = new Elf("Ryan", sleigh, clock);
        Elf e2 = new Elf("Matt", sleigh, clock);
        Elf e3 = new Elf("Beradin", sleigh, clock);
        Elf e4 = new Elf("Liam", sleigh,clock);
        Elf e5 = new Elf("Jack", sleigh, clock);
         
        Santa s1 = new Santa("Santa Nick", sleigh, clock);
        Santa s2 = new Santa("Santa Paul", sleigh, clock);
        Santa s3 = new Santa("Santa John", sleigh, clock);
        
        clock.start();
         
        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();
         
        s1.start();
        s2.start();
        s3.start();
        
         
        try {
            clock.join();
            
            
            e1.join();
            e2.join();
            e3.join();
            e4.join();
            e5.join();
            
           
        } catch (InterruptedException ex) {
          
        }
        
        System.out.println("********SANTA******");
        
         try {
            
            
            s1.join();
            s2.join();
            s3.join();
            
            
           
        } catch (InterruptedException ex) {
            
        }
        
        
         
       
         
        System.out.println("Finished");
    }
    
}
