/*
 * Created on Nov 23, 2020
 *
 */
package music;

public class AlreadyPlayedException extends Exception {
    
    private Song song;

    public AlreadyPlayedException(Song song) {
        super();
        this.song = song;
    }

    public AlreadyPlayedException() {
        super();
    }
    
    @Override
    public String getMessage() {
        return "song " + this.song.toString() + " already played, repeat is off";
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

}
