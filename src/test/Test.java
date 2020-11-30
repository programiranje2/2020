/*
 * Created on Oct 4, 2020
 *
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import music.Album;
import music.AlreadyPlayedException;
import music.Artist;
import music.Band;
import music.Dancer;
import music.Genre;
import music.HallOfFameRockMusician;
import music.Musician;
import music.Performer;
import music.Playlist;
import music.RockMusician;
import music.Song;
import music.SongNotInPlaylistException;
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
        Performer johnLennon = new Musician("John", false, 80, Nationality.UK);
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
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
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
        
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Performer paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        Performer georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
        Performer ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
        Performer[] theBeatles = {johnLennon, paulMcCartney, georgeHarrison, ringoStarr};
        
        for (Performer m : theBeatles) {
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
    
    public void testNumberFormating() {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(6 / 7);
        System.out.println((double) 6 / 7);
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format((double) 6 / 7));
        nf.setMaximumFractionDigits(3);
        System.out.println(nf.format((double) 6 / 7));
    }
    
    public void testStrings() {
        String john = "John Lennon";
        System.out.println(john.charAt(5));
        System.out.println(john.concat(" was born in Liverpool, UK."));
        System.out.println(john.endsWith("Lennon"));
        System.out.println(john.startsWith("John"));
        System.out.println(john.substring(5, john.length()));
        String[] words = john.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println(String.join(" ", words));
        System.out.println();
        System.out.println(Integer.parseInt("123"));
        System.out.println(String.valueOf(123));
        System.out.println(String.format("%s%.2f", "6 / 7: ", (double) 6 / 7));
        System.out.printf(String.format("%s%.2f", "6 / 7: ", (double) 6 / 7));
    }
    
    public void testStringBuffers() {
        StringBuffer sb = new StringBuffer("John Lennon");
        sb.append(" was born in ");
        sb.append(1940).append(" in Liverpool !!!").delete(sb.length() - 4, sb.length()).append('.');
        System.out.println(sb);
        System.out.println();
        
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        
        Song[] songs = {mother, lookAtMe, god};
        Album jLennon = new Album("John Lennon / Plastic Ono Band", songs);
        System.out.println(jLennon);
    }
    
    public void testEquals() {
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Performer jLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        System.out.println("johnLennon == jLennon:   " + (johnLennon == jLennon));
        System.out.println("johnLennon.equals(jLennon):   " + (johnLennon.equals(jLennon)));
    }
    
    public void testArrayLists() {
//        ArrayList<String> songTitles = new ArrayList<String>();
//        String[] titles = {"Look at Me", "Mother", "Working Class Hero"};
//        for (String t : titles) {
//            songTitles.add(t);
//        }
//        System.out.println(songTitles);
//        System.out.println(String.join(", ", songTitles.toArray(new String[songTitles.size()])));
//        System.out.println();
//        System.out.println(songTitles.get(1));
//        songTitles.remove(1);
//        System.out.println(songTitles);
        
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        Musician georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
        Musician ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
        ArrayList<Musician> theBeatlesList = new ArrayList<Musician>();
        
        Band theBeatles = new Band("The Beatles", theBeatlesList);
        
        theBeatles.addMember(johnLennon);
        theBeatles.addMember(paulMcCartney);
        theBeatles.addMember(georgeHarrison);
        theBeatles.addMember(ringoStarr);
        System.out.println(theBeatles);
        System.out.println();
        System.out.println(theBeatles.getMembers().get(3));
        System.out.println();
        
        theBeatles.addMember(ringoStarr);
        System.out.println(theBeatles);
        System.out.println();
        
        theBeatles.removeMember(johnLennon);
        System.out.println(theBeatles);
    }
    
    public void testGregorianCalendar() {
//        GregorianCalendar c = new GregorianCalendar();
//        System.out.println(c);
//        System.out.println(c.getTime());
//        System.out.println(c.get(Calendar.YEAR));
//        System.out.println(c.get(Calendar.MONTH));
//        System.out.println(c.get(Calendar.DAY_OF_MONTH));
//        System.out.println();
//        
//        GregorianCalendar jBirthday = new GregorianCalendar(1940, 9, 9);
//        System.out.println(jBirthday.getTime());
//        System.out.println((new SimpleDateFormat("EEE, MMM dd, yyyy")).format(jBirthday.getTime()));
        
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        
        Song[] songs = {mother, lookAtMe, god};
        Album jLennon = new Album("John Lennon / Plastic Ono Band", songs);
        System.out.println(jLennon);
        jLennon.setReleaseDate(new GregorianCalendar(1970, 11, 11));
        System.out.println(jLennon);
        jLennon.setReleaseDate(new GregorianCalendar(1870, 11, 11));
        System.out.println(jLennon);
    }
    
    public void testInheritance() {
        ArrayList<Genre> genres = new ArrayList<Genre>();
        genres.add(Genre.CLASSIC_ROCK);
        genres.add(Genre.POP_ROCK);
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        RockMusician lennon = new RockMusician("John Lennon", false, 80, Nationality.UK, genres);
        System.out.println(lennon);
        System.out.println(johnLennon.equals(lennon));
//        lennon = johnLennon;                          // no, RockMusician is more specific than Musician
        johnLennon = lennon;
//        System.out.println(johnLennon.getGenres());   // no, johnLennon is a Musician object, and Musician objects ton't have getGenres()
    }
    
    public void testPolymorphism() {
        ArrayList<Genre> genres = new ArrayList<Genre>();
        genres.add(Genre.CLASSIC_ROCK);
        genres.add(Genre.POP_ROCK);
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        RockMusician lennon = new RockMusician("John Lennon", false, 80, Nationality.UK, genres);
        HallOfFameRockMusician jLennon = new HallOfFameRockMusician("John Lennon", false, 80, Nationality.UK, genres, new GregorianCalendar(1994, 0, 19));
        
        johnLennon.play();
        System.out.println();
        lennon.play();
        System.out.println();
        jLennon.play();
        System.out.println();
        
        Musician jl = jLennon;
        jl.play();
    }
    
    public void testAbstractClasses() {
//        Performer p = new Performer();    // no, Performer is an abstract class
        Performer p = new Musician();       // this is OK - instantiating by a subclass object
        
        ArrayList<Genre> genres = new ArrayList<Genre>();
        genres.add(Genre.CLASSIC_ROCK);
        genres.add(Genre.POP_ROCK);
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Performer lennon = new RockMusician("John Lennon", false, 80, Nationality.UK, genres);
        HallOfFameRockMusician jLennon = new HallOfFameRockMusician("John Lennon", false, 80, Nationality.UK, genres, new GregorianCalendar(1994, 0, 19));
        
        johnLennon.perform();
        System.out.println();
        lennon.perform();
        System.out.println();
        jLennon.play();
        System.out.println();
        System.out.println();
        
        Performer madonna = new Dancer("Madonna", 50, Nationality.USA);
        madonna.perform();
    }
    
    public void testInterfaces() {
        Artist johnLennon = new Musician("John Lennon", -1, Nationality.UK);
        Artist jLennon = new RockMusician("John Lennon", -1, Nationality.UK);
        johnLennon.display();
        jLennon.display();
        System.out.println();
        
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(Genre.CLASSIC_ROCK);
        genres.add(Genre.POP_ROCK);
        System.out.println(genres);

    }
    
    public void testIterators() {
        Musician johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        Musician paulMcCartney = new Musician("Paul McCartney", true, 78, Nationality.UK);
        Musician georgeHarrison = new Musician("George Harrison", false, 77, Nationality.UK);
        Musician ringoStarr = new Musician("Ringo Starr", true, 80, Nationality.UK);
        
        ArrayList<Musician> theBeatlesList = new ArrayList<Musician>();
        theBeatlesList.add(johnLennon);
        theBeatlesList.add(paulMcCartney);
        theBeatlesList.add(georgeHarrison);
        theBeatlesList.add(ringoStarr);
        
//        // This does not work, throws java.util.ConcurrentModificationException
//        for (Musician m : theBeatlesList) {
//            theBeatlesList.remove(m);
//        }
        
        Iterator<Musician> i = theBeatlesList.iterator();
        while (i.hasNext()) {
            System.out.println(theBeatlesList);
            i.next();
            i.remove();
        }
        
        System.out.println(i.hasNext());
//        System.out.println(i.next());         // no more, iterator is exhausted
    }
    
    public void testExceptions() {
//        int[] n = {1, 2, 3};
//        for (int i = 0; i <= n.length; i++) {
//            System.out.println(n[i]);
//        }
        
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970); 
        Song god = new Song("God", johnLennon, 1970); 
        Song isolation = new Song("Isolation", johnLennon, 1970); 
        
        Playlist playlist = new Playlist();
        playlist.setTitle("John Lennon / Plastic Ono Band");
        
        playlist.add(mother);
        playlist.add(lookAtMe);
        playlist.add(god);
        
//        System.out.println(playlist);
//        System.out.println();
        
//        playlist.setRepeat(false);
        playlist.playAll();
//        playlist.playAll();
        System.out.println();
        
        try {
            playlist.playSong(isolation);
//            playlist.playSong(mother);
        } catch (AlreadyPlayedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SongNotInPlaylistException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            System.err.println("Can't play song: " + e.getMessage());
        } finally {
            System.out.println("Finally...");
        }
        
//        playlist.setRepeat(true);
        playlist.playAll();
    }
    
    public void testIO () {
        
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        
        Song mother = new Song("Mother", johnLennon, 1970); 
        Song lookAtMe = new Song("Look at Me", johnLennon, 1970);
        
        PrintWriter out = null;
        
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(new File("test.txt"))));
            out.println(mother.getTitle());
            out.println(mother.getYear());
            out.println(lookAtMe.getTitle());
            out.println(lookAtMe.getYear());
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("Done.");
        }
        
        BufferedReader in = null;
        Song s1 = new Song();
        Song s2 = new Song();
        try {
            in = new BufferedReader(new FileReader(new File("test.txt")));
            s1.setTitle(in.readLine());
            s1.setYear(Integer.parseInt(in.readLine()));
            s2.setTitle(in.readLine());
            s2.setYear(Integer.parseInt(in.readLine()));
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("Songs read, but no authors set.");
        }
        s1.setAuthor(johnLennon);
        s2.setAuthor(johnLennon);
        System.out.println(s1);
        System.out.println(s2);
        
        in = new BufferedReader(new InputStreamReader(System.in));
        String something = null;
        System.out.print("Read something: ");
        try {
            something = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(something);
    }
    
    public void testSerialization() {
        Performer johnLennon = new Musician("John Lennon", false, 80, Nationality.UK);
        
        Song mother = new Song("Mother", johnLennon, 1970); 
        
        mother.serialize("mother.serialized");
    }
    
    public void testDeserialization() {
        Song mother = Song.deserialize("mother.serialized");
        System.out.println(mother);
    }

}
