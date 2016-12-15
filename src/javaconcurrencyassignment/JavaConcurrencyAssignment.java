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
         
        Elf e1 = new Elf("Elf Ryan", sleigh, clock);
        Elf e2 = new Elf("Elf Matt", sleigh, clock);
        Elf e3 = new Elf("Elf Beradin", sleigh, clock);
        Elf e4 = new Elf("Elf Liam", sleigh,clock);
        Elf e5 = new Elf("Elf Jack", sleigh, clock);
        Elf e6 = new Elf("Elf Ryan2", sleigh, clock);
        Elf e7 = new Elf("Elf Matt3", sleigh, clock);
        Elf e8 = new Elf("Elf Beradin3", sleigh, clock);
        Elf e9 = new Elf("Elf Liam3", sleigh,clock);
        Elf e10 = new Elf("Elf Jack3", sleigh, clock);
         
        Santa s1 = new Santa("Santa Nick", sleigh, clock);
        Santa s2 = new Santa("Santa Paul", sleigh, clock);
        Santa s3 = new Santa("Santa Peter", sleigh, clock);
        Santa s4 = new Santa("Santa Nick2", sleigh, clock);
        Santa s5 = new Santa("Santa Paul2", sleigh, clock);
        Santa s6 = new Santa("Santa Peter2", sleigh, clock);
        Santa s7 = new Santa("Santa Nick3", sleigh, clock);
        Santa s8 = new Santa("Santa Paul3", sleigh, clock);
        Santa s9 = new Santa("Santa Peter3", sleigh, clock);
        
        clock.start();
         
        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();
        e6.start();
        e7.start();
        e8.start();
        e9.start();
        e10.start();
         
         
        s1.start();
//        s2.start();
//        s3.start();
//        s4.start();
//        s5.start();
//        s6.start();
//        s7.start();
//        s8.start();
//        s9.start();
        
         
        try {
            clock.join();
            
            
            e1.join();
           
            e2.join();
            
            e3.join();
            
            e4.join();
            
            e5.join();
            
            e6.join();
           
            e7.join();
            
            e8.join();
            
            e9.join();
            
            e10.join();
           
            
           
        } catch (InterruptedException ex) {
          
        }
        
        System.out.println("********SANTA******");
        
         try {
            
            
            s1.join();
           
//            s2.join();
//            
//            s3.join();
//            
//            s4.join();
//           
//            s5.join();
//            
//            s6.join(); 
//            
//            s7.join();
//           
//            s8.join();
//            
//            s9.join();
            
            
           
        } catch (InterruptedException ex) {
            
        }
        
        
         
       sleigh.report();
         
        System.out.println("Finished");
    }
    
}
