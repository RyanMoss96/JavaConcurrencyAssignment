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
    int num_presents_given = 0;
    float time_at_empty_sleigh = 0;
    
    Sack[] santaSack;
    
    
    public Santa(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public void run() {
        
        
        
    }
}
