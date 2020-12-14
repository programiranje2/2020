/*
 * Created on Oct 4, 2020
 *
 */
package music;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Song implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private String title;
    private Performer author;
    private int year;
    private String lyrics;
    
    public Song(String title, Performer author, int year, String lyrics) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.lyrics = lyrics;
    }

    public Song(String title, Performer author, int year) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Song() {
        super();
    }
    
    public void serialize(String filename) {
//        ObjectOutputStream out;
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))))) {
//            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))));
            out.writeObject(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.println("Done.");
        }
    }
    
    public static Song deserialize(String filename) {
        Song s = null;
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filename))))) {
//          out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filename))));
          s = (Song) in.readObject();
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
          System.out.println("Done.");
      }
        return s;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.title + " (" + this.author.getName() + "), " + this.year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Performer getAuthor() {
        return author;
    }

    public void setAuthor(Performer author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    
    

}
