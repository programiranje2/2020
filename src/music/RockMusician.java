/*
 * Created on Nov 1, 2020
 *
 */
package music;

import java.util.ArrayList;

import util.Nationality;

public class RockMusician extends Musician {
    
    protected ArrayList<Genre> genres = new ArrayList<Genre>();

    public RockMusician(String name, boolean alive, int age, Nationality nationality, ArrayList<Genre> genres) {
        super(name, alive, age, nationality);
        if (genres != null) {
            this.genres = genres;
        } 
    }

    public RockMusician(String name, int age, Nationality nationality) {
//        super(name, age, nationality);
//        super(name, true, age, nationality);
        this(name, true, age, nationality, null);
        // TODO Auto-generated constructor stub
    }

    public RockMusician() {
        super();
//        this(null, false, 0, null, null);
        // TODO Auto-generated constructor stub
    }
    
    public void play() {
        super.play();
        System.out.println("rock 'n' roll...");
    }
    
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(this.name + ", rock musician");
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer();
        for (Genre g : this.genres) {
            sb.append(g.name().toLowerCase().replaceAll("_", " ")).append(", ");
        }
        if (sb.length() >=2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return super.toString() + "\n\tgenre(s): " + (sb.length() >= 2 ? sb : "unspecified");
    }
    
    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof RockMusician) {
            RockMusician m = (RockMusician) arg0;
            return super.equals(m) && this.genres.equals(m.genres);
        }
        return super.equals(arg0);
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

}
