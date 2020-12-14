/*
 * Created on Nov 8, 2020
 *
 */
package music;

import java.io.Serializable;

import javax.swing.Icon;

import util.Nationality;

public abstract class Performer implements Serializable {
    
    static final long serialVersionUID = 3L;


    protected String name;
    protected boolean alive;
    protected int age;
    protected Nationality nationality;
    protected Icon icon;

    public Performer() {
        super();
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
    public abstract void perform();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

}