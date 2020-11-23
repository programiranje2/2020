/*
 * Created on Oct 4, 2020
 *
 */
package music;

import util.Nationality;
import util.PerformingArt;

public class Musician extends Performer implements Artist {
    
    private static String definition;
    protected static final PerformingArt performingArt = PerformingArt.MUSIC;
    
    static {
        definition = "A person who composes or performs music.";
    }
    
    public Musician(String name, boolean alive, int age, Nationality nationality) {
        super();
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.nationality = nationality;
    }

    public Musician(String name, int age, Nationality nationality) {
        super();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Musician() {
        super();
    }
    
    public static void showDefinition() {
        System.out.println(definition);
    }
    
    @Override
    public void perform() {
        this.play();
    }
    
    @Override
    public void display() {
        System.out.println(this.name + ", musician");
    }

    public void play() {
        System.out.println(this.name + " is playing...");
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name + " (" + this.nationality.name() + "), " + (this.alive ? this.age : "passed away");
    }
    
    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Musician)) {
            return false;
        }
        Musician m = (Musician) arg0;
        if ((m.getName().equals(this.getName()) && (m.getAge() == this.getAge()) && (m.getNationality() == this.getNationality()))) {
            return true;
        }
        return false;
    }

    public static String getDefinition() {
        return definition;
    }

    public static void setDefinition(String definition) {
        Musician.definition = definition;
    }

    public static PerformingArt getPerformingart() {
        return performingArt;
    }
    
}
