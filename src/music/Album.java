/*
 * Created on Oct 9, 2020
 *
 */
package music;

public class Album {
    
    private String title;
    private Song[] songs;
    
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
        return this.title + ":\n\t" + s.toString();
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

}
