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
public class Santa extends Thread {

    private String name;
    private String department;
    private Sleigh sleigh;
    private int num_presents_given = 0;
    private float time_at_empty_sleigh = 0;
    private final int base_wait_time = 10;
    private String[] genders = {"Boy", "Girl"};

    private Sack santaSack;
    private Clock clock;
    private PrintWriter writer;

    public Santa(String name, Sleigh sleigh, Clock clock) {
        this.name = name;
        //this.department = department;
        this.sleigh = sleigh;
        this.clock = clock;

        santaSack = new Sack();
    }

    public void run() {

        openFileForWriting();

        while (!clock.dayOver()) {

            while (santaSack.numberOfPresents() < santaSack.maxPresents()) {
                getPresents();
            }
            
            //Walking back to their department
            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException ex) {

            }
            
            while(!santaSack.isEmpty()) {
                givePresentsToChildren();
            }

//            
            

        }
        closeFileForWriting();

    }

    private void getPresents() {

        Presents item = sleigh.removePresent();

        System.out.println("*************** " + name + " " + " " + item.type + " " + item.gender);

        santaSack.addToy(item);

    }

    private void givePresentsToChildren() {

        //Spend a random amount of time with each child
        try {
            sleep((int) (Math.random() * 10));
        } catch (InterruptedException ex) {

        }

        String gender = selectGender();

        Presents present = santaSack.removeToy(gender);

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
}
