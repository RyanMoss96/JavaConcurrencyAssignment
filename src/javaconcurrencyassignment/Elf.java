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
public class Elf extends Thread {
    
    String name;
    int total_presents_wrapped = 0;
    float time_at_sleigh = 0;
    Sleigh sleigh;
    
    public Elf(String name, Sleigh s) {
        this.name = name;
        this.sleigh = s;
    }
    
    private void createPresent() {
        
    }
    
    public void run() {
        
    }
}
