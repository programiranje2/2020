/*
 * Created on Nov 23, 2020
 *
 */
package music;

public class SongNotInPlaylistException extends Exception {
    
    private Song song;
    private Playlist playlist;
    
    public SongNotInPlaylistException(Song song, Playlist playlist) {
        super();
        this.song = song;
        this.playlist = playlist;
    }
    
    public SongNotInPlaylistException() {
        super();
    }
    
    @Override
    public String getMessage() {
        return "song " + this.song + " not in playlist " + this.playlist.getTitle();
    }
    
    public Song getSong() {
        return song;
    }
    public void setSong(Song song) {
        this.song = song;
    }
    public Playlist getPlaylist() {
        return playlist;
    }
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

}
