/*
 * Created on Oct 4, 2020
 *
 */
package test;

import java.util.Scanner;

import music.Album;
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
    
    public void testStatic() {
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        johnLennon.showDefinition();    // OK, but not typical
        Musician.showDefinition();      // typical
        System.out.println();
        
//        System.out.println(johnLennon.definition);        // no, definition is private
        System.out.println(johnLennon.getDefinition());     // OK, but not typical
        System.out.println();
        
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        paulMcCartney.setDefinition("An artist who performs music.");
        System.out.println(johnLennon.getDefinition());
        System.out.println();
        
        System.out.println(Math.PI);
    }
    
    public void testArrays() {
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
    
    public void testLoops() {
        System.out.println("for loop:");
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            System.out.println("a[" + i + "] = " + a[i]);
        }
        System.out.println();
        
        System.out.println("while loop:");
        int i = 0;
        while (i < a.length) {
            System.out.println("a[" + i + "] = " + a[i]);
            i = i + 1;
        }
        System.out.println();
        
        System.out.println("do-while loop:");
        i = 0;
        do {
            System.out.println("a[" + i + "] = " + a[i]);
            i++;
        } while (i < a.length);
        System.out.println();
        
        System.out.println("'for each' loop:");
        for (int j : a) {
            System.out.println(j);
            System.out.println("a[" + (j - 1) + "] = " + j);
        }
    }
    
    public void testBreakAndContinue() {
        System.out.println("for loop:");
        int[] a = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            if (i == 1) {
//                break;
                continue;
            }
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
    
    public void testArraysOfObjects() {
//        Musician[] theBeatles = new Musician[4];
//        theBeatles[0] = new Musician("John Lennon", false, 80, Nationality.UK);
//        theBeatles[1] = new Musician("Paul McCartney", true, 78, Nationality.UK);
//        theBeatles[2] = new Musician("George Harrison", false, 77, Nationality.UK);
//        theBeatles[3] = new Musician("Ringo Starr", true, 80, Nationality.UK);
        
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        Musician georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
        Musician ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
        Musician[] theBeatles = {johnLennon, paulMcCartney, georgeHarrison, ringoStarr};
        
        for (Musician m : theBeatles) {
            System.out.println(m);
        }
        
        System.out.println();
        
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        
        Song[] songs = {mother, lookAtMe, god};
        Album jLennon = new Album("John Lennon / Plastic Ono Band", songs);
        System.out.println(jLennon);
    }
    
    public void testSwitch() {
        System.out.print("Read an int between 1 and 4: ");
        int i = IN.nextInt();
        switch (i) {
            case 1: System.out.println("John"); break;
            case 2: System.out.println("Paul"); break;
            case 3: System.out.println("George"); break;
            case 4: System.out.println("Ringo"); break;
        }
    }
    
    public void testIntegerAndDouble() {
        Integer i = new Integer(2);
        Double d = new Double(3.8);
        
        System.out.println("i.doubleValue() = " + i.doubleValue());
        System.out.println("d.intValue() = " + d.intValue());
        System.out.println("d rounded = " + Math.round(d));
    }

}
