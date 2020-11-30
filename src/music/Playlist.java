/*
 * Created on Nov 23, 2020
 *
 */
package music;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    private String title;
    private List<Song> songs = new ArrayList<Song>();
    private List<Boolean> alreadyPlayed = new ArrayList<Boolean>();
    private boolean shuffle = false;
    private boolean repeat = false;
    
    public Playlist(String title, List<Song> songs, List<Boolean> alreadyPlayed, boolean shuffle, boolean repeat) {
        super();
        this.title = title;
        this.songs = songs;
        this.alreadyPlayed = alreadyPlayed;
        this.shuffle = shuffle;
        this.repeat = repeat;
    }

    public Playlist() {
        super();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.songs.size(); i++) {
            sb.append(this.songs.get(i).toString() + " (" + (this.alreadyPlayed.get(i) ? "already played" : "not played yet") + ")\n");
        }
        return sb.toString();
    }
    
    public void add(Song s) {
        this.songs.add(s);
        this.alreadyPlayed.add(false);
    }
    
    public void playSong(Song s) throws AlreadyPlayedException, SongNotInPlaylistException {
//        System.out.println(s);
        int i = this.songs.indexOf(s);
        if (!((i >= 0) && (i < this.songs.size())))
            throw new SongNotInPlaylistException(s, this);
        if (!this.alreadyPlayed.get(i)) {
            System.out.println("Playing " + s);
            this.alreadyPlayed.set(i, true);
        } else {
            if (repeat) {
                System.out.println("Playing " + s);
            } else {
                throw new AlreadyPlayedException(s);                
            }
        }
    }
    
    public void playAll() {
        for (Song s : this.songs) {
            try {
                playSong(s);
            } catch (AlreadyPlayedException e) {
//                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            } catch (SongNotInPlaylistException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Boolean> getAlreadyPlayed() {
        return alreadyPlayed;
    }

    public void setAlreadyPlayed(List<Boolean> alreadyPlayed) {
        this.alreadyPlayed = alreadyPlayed;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

}
