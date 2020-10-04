/*
 * Created on Oct 4, 2020
 *
 */
package test;

import java.util.Scanner;

import music.Musician;
import music.Song;
import util.Nationality;

public class Test {
    
    public static final Scanner IN = new Scanner(System.in);
    
    public void testPrintln() {
        System.out.println("John Lennon" + " was one of the greatest men of the 20th century" + '\n' + 
                            "and his life and work have inspired this class.");
    }
    
    public void testScanner() {
        System.out.print("Read a line: ");
        String s = IN.nextLine();
        System.out.println("You entered: " + s);
    }
    
    public void testMusician() {
        Musician johnLennon = new Musician("John", false, 80, Nationality.UK);
        System.out.println(johnLennon.getName() + " was 40 when he got assassinated.");
        johnLennon.setName("John Lennon");
        System.out.print(johnLennon.getName());
        if (johnLennon.isAlive()) {
            System.out.println(" (" + johnLennon.getAge() + ")");
        } else {
            System.out.println(" (passed away)");
        }
//        System.out.println(johnLennon.getName() + " was 40 when he got assassinated.");
        System.out.println(johnLennon);
    }
    
    public void testSong() {
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Song imagine = new Song("Imagine", johnLennon, 1971);
        System.out.println(imagine);
    }

}
