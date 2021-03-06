package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Company generated by hbm2java
 */
public class Company  implements java.io.Serializable {


     private long numbercompany;
     private String name;
     private Set<Users> userses = new HashSet<Users>(0);

    public Company() {
    }

	
    public Company(long numbercompany, String name) {
        this.numbercompany = numbercompany;
        this.name = name;
    }
    public Company(long numbercompany, String name, Set<Users> userses) {
       this.numbercompany = numbercompany;
       this.name = name;
       this.userses = userses;
    }
   
    public long getNumbercompany() {
        return this.numbercompany;
    }
    
    public void setNumbercompany(long numbercompany) {
        this.numbercompany = numbercompany;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.numbercompany ^ (this.numbercompany >>> 32));
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.userses);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (this.numbercompany != other.numbercompany) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.userses, other.userses)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Company{" + "numbercompany=" + numbercompany + ", name=" + name + ", userses=" + userses + '}';
    }




}


