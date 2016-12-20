/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrencyassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author ryanmoss
 */
public class Santa extends Thread {

    private String name;
    private String department;
    private Sleigh sleigh;
    private int num_presents_given = 0;
    private int time_at_empty_sleigh = 0;
    private int walk_time;
    private String[] genders = {"Boy", "Girl"};
    private String[] departments = {"Clothes", "Perfume", "Outdoors", "Pharmacy", "Sport"};
    

    private Sack santaSack;
    private Clock clock;
    private PrintWriter writer;

    public Santa(String name, Sleigh sleigh, Clock clock) {
        this.name = name;
        this.sleigh = sleigh;
        this.clock = clock;
        department = departments[randInt(0,5)];
        
        walk_time = (int) (Math.random() * 1001);
        
        santaSack = new Sack();
        
        
        
    }

    public void run() {
        System.out.println(name + " started");
        openFileForWriting();

        while (!clock.dayOver()) {
            
            int start = 0;
            
            boolean emptySleigh = sleigh.sleighEmpty();
            
            if(emptySleigh) {
                start = clock.getTime();
            }
           
            while (santaSack.isEmpty()) {
                if(sleigh.getNumberPresents() < 6) {
                    
                } else {
                    getPresents();
                }
                
            }
            
            if(emptySleigh) {
               time_at_empty_sleigh += clock.getTime() - start;
            }
            
            

            //Walking back to their department
            try {
                sleep(walk_time);
            } catch (InterruptedException ex) {

            }

            while (!santaSack.isEmpty()) {
                givePresentsToChildren();
            }

     if (clock.getTime() % 60 == 0 && clock.getTime() != 480) {
               reportHourly(clock.getTime());
            }

           
        }
        closeFileForWriting();

        reportToConsole();

    }

    private void getPresents() {
        if (sleigh.getNumberPresents() < 6) {

        } else {
            Presents item = sleigh.removePresent();
            //System.out.println("*************** " + name + " " + " " + item.type + " " + item.gender);
            santaSack.addToy(item);
        }

    }

    private void givePresentsToChildren() {

        //Spend a random amount of time with each child
        try {
             sleep((int) (Math.random() * 1001));
        } catch (InterruptedException ex) {

        }

        String gender = selectGender();

        Presents present = santaSack.removeToy(gender);
        num_presents_given++;

        writeToFile("Time " + clock.getTime() + name + ": Gave Toy " + present.type + ", " + present.gender);

    }

    private String selectGender() {
        int random = randInt(0, 2);
        return genders[random];
    }

    private static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min));

        return randomNum;
    }

    private void openFileForWriting() {
        try {
            writer = new PrintWriter(name + "-output.txt", "UTF-8");
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

    private void reportToConsole() {
        System.out.println("FINAL REPORT");
        System.out.println(name + " has given away " + num_presents_given + " presents.");
        System.out.println(name + " spent " + time_at_empty_sleigh + "ticks at an empty sleigh");
    }

    private void reportHourly(int time) {
        System.out.println("HOURLY REPORT: " + time);
        System.out.println(name + " has given away " + num_presents_given + " presents.");
        System.out.println(name + " spent " + time_at_empty_sleigh + "ticks at an empty sleigh");
        System.out.println();
    }
}
