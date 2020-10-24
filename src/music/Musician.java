/*
 * Created on Oct 4, 2020
 *
 */
package music;

import util.Nationality;

public class Musician {
    
    private static String definition;
    
    private String name;
    private boolean alive;
    private int age;
    private Nationality nationality;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public static String getDefinition() {
        return definition;
    }

    public static void setDefinition(String definition) {
        Musician.definition = definition;
    }
    
}
