/*
 * Created on Oct 9, 2020
 *
 */
package music;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Album {
    
    public static final GregorianCalendar FIRST_EVER = new GregorianCalendar(1909, 3, 10);
    
    private String title;
    private Song[] songs;
    private GregorianCalendar releaseDate;
    
    public Album(String title, Song[] songs, GregorianCalendar releaseDate) {
        super();
        this.title = title;
        this.songs = songs;
        setReleaseDate(releaseDate);
    }

    public Album(String title, Song[] songs) {
        super();
        this.title = title;
        this.songs = songs;
    }

    public Album(String title, int noOfSongs) {
        super();
        this.title = title;
        this.songs = new Song[noOfSongs];       // but remember that each song is null, so create them as well
        for (int i = 0; i < noOfSongs; i++) {
            songs[i] = new Song();
        }
    }

    public Album() {
        super();
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
//        return this.title + " (" + this.songs.length + " songs)";
        StringBuffer s = new StringBuffer();
        for (Song song : this.songs) {
            s.append(song.toString() + "\n\t");
        }
        StringBuffer released = new StringBuffer();
        if (this.releaseDate != null) {
            released.append(" (release date: " + (new SimpleDateFormat("EEE, MMM dd, YYYY")).format(this.releaseDate.getTime()) + ")");
        } else {
            released.append(" (release date: unknown)");
        }
        return this.title + released + ":\n\t" + s.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public GregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(GregorianCalendar releaseDate) {
        if (releaseDate.after(FIRST_EVER)) {
            this.releaseDate = releaseDate;
        } else {
            System.out.println("releaseDate must be after FIRST_EVER; set to null by default");
            this.releaseDate = null;
        }
    }

}
