/*
 * Created on Oct 18, 2020
 *
 */
package music;

import java.util.ArrayList;

public class Band {
    
    private String name;
    private ArrayList<Musician> members;
    
    public Band(String name, ArrayList<Musician> members) {
        super();
        this.name = name;
        this.members = members;
    } 
    
    public Band() {
        super();
    }
    
    public boolean addMember(Musician m) {
        if (!this.members.contains(m)) {
            return this.members.add(m);
        } else {
            return false;
        }
    }
    
    public boolean removeMember(Musician m) {
        if (this.members.contains(m)) {
            return this.members.remove(m);
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer();
        for (Musician m : members) {
            sb.append(m.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return this.name + "(" + sb.toString() + ")";
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Musician> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<Musician> members) {
        this.members = members;
    }
    

}
