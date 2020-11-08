/*
 * Created on Nov 8, 2020
 *
 */
package music;

import util.Nationality;
import util.PerformingArt;

public class Dancer extends Performer {

    protected static final PerformingArt performingArt = PerformingArt.DANCING;
    
    public Dancer(String name, boolean alive, int age, Nationality nationality) {
        super();
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.nationality = nationality;
    }

    public Dancer(String name, int age, Nationality nationality) {
        super();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
    
    public Dancer() {
        super();
    }
    
    @Override
    public void perform() {
        System.out.println(this.name + " is dancing...");
    }

}
