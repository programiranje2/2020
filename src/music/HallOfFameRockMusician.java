/*
 * Created on Nov 2, 2020
 *
 */
package music;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import util.Nationality;

public class HallOfFameRockMusician extends RockMusician {
    
    private GregorianCalendar inducted;

    public HallOfFameRockMusician(String name, boolean alive, int age, Nationality nationality,
            ArrayList<Genre> genres, GregorianCalendar inducted) {
        super(name, alive, age, nationality, genres);
        this.inducted = inducted;
    }

    public void play() {
        super.play();
        System.out.println(this.name + " is an iductee of The Rock 'n' Roll Hall of Fame.");
    }
    
    public HallOfFameRockMusician() {
        super();
    }

    public GregorianCalendar getInducted() {
        return inducted;
    }

    public void setInducted(GregorianCalendar inducted) {
        this.inducted = inducted;
    }

}
