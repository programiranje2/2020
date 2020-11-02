/*
 * Created on Nov 2, 2020
 *
 */
package music;

import util.Nationality;

public class SoloMusician extends Musician {
    
    private Instrument instrument;

    public SoloMusician(String name, boolean alive, int age, Nationality nationality, Instrument instrument) {
        super(name, alive, age, nationality);
        this.instrument = instrument;
    }

    public SoloMusician() {
        super();
    }

}
