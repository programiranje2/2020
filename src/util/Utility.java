/*
 * Created on Nov 25, 2019
 *
 */
package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import music.Musician;
import music.Song;

public class Utility {
    
    public static String getProjectDir() {
        StringBuffer projectDir = (new StringBuffer(new File(".").getAbsolutePath()));
        projectDir.delete(projectDir.length()-1, projectDir.length());
        return projectDir.toString();
    }
    
    public static String makeProjectSubdir(String subdir) {
        File projectSubdir = new File(getProjectDir(), subdir);
        projectSubdir.mkdirs();
        return projectSubdir.getAbsolutePath();
    }
    
    public static String getDataDir() {
        return makeProjectSubdir("data\\") + "\\";
    }
    
    public static String getResourcesDir() {
        return makeProjectSubdir("resources\\") + "\\";
    }
    
    public static ArrayList<String> getLyricsFilenames() {
        ArrayList<String> lyricsFilenames = new ArrayList<String>();
        File[] allFiles = (new File(Utility.getResourcesDir())).listFiles();
        for (File f : allFiles) {
            if (f.getName().toLowerCase().endsWith(".txt")) {
                lyricsFilenames.add(f.getName());
            }
        }
        return lyricsFilenames;
    }
    
    public static ArrayList<String> getPhotoFilenames() {
        ArrayList<String> photoFilenames = new ArrayList<String>();
        File[] allFiles = (new File(Utility.getResourcesDir())).listFiles();
        for (File f : allFiles) {
            if (!f.getName().toLowerCase().endsWith(".txt")) {
                photoFilenames.add(f.getName());
            }
        }
        return photoFilenames;
    }

    public static Musician findMusician(String name, List<Musician> musicians) {
        for (Musician m : musicians) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }
    
    public static Song findSong(String title, List<Song> songs) {
        for (Song s : songs) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }
    
}
