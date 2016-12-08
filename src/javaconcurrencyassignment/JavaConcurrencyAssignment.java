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
        
         final int MAX_NUMBER_ELVES = 5;
         final int MAX_NUMBER_SANTAS = 3;
         
         String[] elfNameArray = {"Ryan", "Matt", "Beradin", "Jack","Connor", "Nick", "Liam", "Tom", "Luke", "Harry"};
         String[] santaNameArray = {"Santa Nick", "Santa John", "Santa Paul"};
         
         Elf[] elves = new Elf[MAX_NUMBER_ELVES];
         Santa[] santas = new Santa[MAX_NUMBER_SANTAS];
         Sleigh sleigh = new Sleigh();
         
        for(int i = 0; i < MAX_NUMBER_ELVES; i++) {
            elves[i] = new Elf(elfNameArray[i], sleigh);
        }
        
        for(int i = 0; i < MAX_NUMBER_SANTAS; i++) {
            santas[i] = new Santa(santaNameArray[i], "Toys", sleigh);
        }
        
        for(int i=0; i < MAX_NUMBER_ELVES; i++) {
           elves[i].start(); 
        }
        
         for(int i=0; i < MAX_NUMBER_SANTAS; i++) {
           santas[i].start(); 
        }
         
         
         try {
           for(int i=0; i < MAX_NUMBER_ELVES; i++) {
           elves[i].join(); 
        }
        
         for(int i=0; i < MAX_NUMBER_SANTAS; i++) {
           santas[i].join(); 
        }
        } catch (InterruptedException ex) {
        }
    }
    
}
