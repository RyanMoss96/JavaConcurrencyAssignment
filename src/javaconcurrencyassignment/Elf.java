/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrencyassignment;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 *
 * @author ryanmoss
 */
public class Elf extends Thread {
    
    private String name;
    private int total_presents_wrapped = 0;
    private int time_at_sleigh = 0;
    private Sleigh sleigh;
    private Presents present;
    private Clock clock;
    private int time;
   
    private String[] present_types =  {"train", "doll", "dinosaur", "whistle", "fake tattoo", "bracelet"};
    private String[] present_genders = {"Boy", "Girl"};
    
    
    private PrintWriter writer;
    
    public Elf(String name, Sleigh sleigh, Clock clock) {
        this.name = name;
        this.sleigh = sleigh;
        this.clock = clock;
        
        present = new Presents();
    }
    
   
    
    public void run() {
        openFileForWriting();
        
        while(!clock.dayOver()) {
           
            //Selecting a present for a random amount of time
            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException ex) {
                
            }
            
            System.out.println(clock.dayOver());
             createPresent(); 
        }
        
        closeFileForWriting();
        
    }
    
     private void createPresent() {
        present.type = selectPresent();
        present.gender = selectGender();
        
       
        time = clock.getTime();
        
        writeToFile("Time " + time + " Elf " + name + ": Selected Toy " + present.type + ", " + present.gender);

        //Random time to simulate wrapping the present
        try {
            sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {
            
        }
        
        
        
        present.wrapped = true;
        total_presents_wrapped++;
        
        if(present.gender.equals("Boy")) {
            present.colourPaper = "Blue";
        } else {
            present.colourPaper = "Pink";
        }
        time = clock.getTime();
        writeToFile("Time " + time + " Elf " + name + ": Wrapped Toy " + present.type + ", in " + present.colourPaper + " wrapping paper.");
        
        int startSleighTime = clock.getTime();
        
         time = clock.getTime();
        writeToFile("Time " + time + " Elf " + name + ": Placed Toy " + present.type + ", on the sleigh. " );
        
        sleigh.addPresent(present);
        
        int endSleighTime = clock.getTime();
        
        int difference = endSleighTime - startSleighTime;
        
        time_at_sleigh += difference;
        
            
        System.out.println(name + " " + " " + present.type + " " + present.gender);
   
    }
     
    private String selectPresent() {
        int random = randInt(0, 6);
        return present_types[random];
    }
     
    private String selectGender() {
        int random = randInt(0,2); 
        return present_genders[random];
    }
     
     private static int randInt(int min, int max) {
        
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min));

        return randomNum;
    }
     
    private void openFileForWriting() {
        try{
            writer = new PrintWriter("Elf-" + name + "-output.txt", "UTF-8");
        } catch (IOException e) {
            // do something
        }
    }
     
    private void writeToFile(String line) {
        writer.println(line);
        
    }
    
    private void closeFileForWriting() {
        writer.close();
    }
}

