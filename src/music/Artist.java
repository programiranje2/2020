/*
 * Created on Nov 8, 2020
 *
 */
package music;

import util.PerformingArt;

public interface Artist {
    
    public void display();
    default public String getArt() {
        return PerformingArt.MUSIC.name().toLowerCase();
    }

}
