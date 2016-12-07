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
         
         Elf[] elves = new Elf[MAX_NUMBER_ELVES];
         Sleigh sleigh = new Sleigh();
         
        for(int i = 0; i < MAX_NUMBER_ELVES; i++) {
            elves[i] = new Elf(elfNameArray[i], sleigh);
        }
        
        for(int i=0; i < MAX_NUMBER_ELVES; i++) {
           elves[i].start(); 
        }
    }
    
}
