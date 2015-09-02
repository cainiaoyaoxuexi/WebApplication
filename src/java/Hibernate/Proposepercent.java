package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Objects;

/**
 * Proposepercent generated by hbm2java
 */
public class Proposepercent  implements java.io.Serializable {


     private ProposepercentId id;
     private Massnegotiation massnegotiation;
     private Users users;
     private BigDecimal percent;
     private String commentmass;
     private String typecommass;

    public Proposepercent() {
    }

	
    public Proposepercent(ProposepercentId id, Massnegotiation massnegotiation, Users users) {
        this.id = id;
        this.massnegotiation = massnegotiation;
        this.users = users;
    }
    public Proposepercent(ProposepercentId id, Massnegotiation massnegotiation, Users users, BigDecimal percent, String commentmass, String typecommass) {
       this.id = id;
       this.massnegotiation = massnegotiation;
       this.users = users;
       this.percent = percent;
       this.commentmass = commentmass;
       this.typecommass = typecommass;
    }
   
    public ProposepercentId getId() {
        return this.id;
    }
    
    public void setId(ProposepercentId id) {
        this.id = id;
    }
    public Massnegotiation getMassnegotiation() {
        return this.massnegotiation;
    }
    
    public void setMassnegotiation(Massnegotiation massnegotiation) {
        this.massnegotiation = massnegotiation;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public BigDecimal getPercent() {
        return this.percent;
    }
    
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
    public String getCommentmass() {
        return this.commentmass;
    }
    
    public void setCommentmass(String commentmass) {
        this.commentmass = commentmass;
    }
    public String getTypecommass() {
        return this.typecommass;
    }
    
    public void setTypecommass(String typecommass) {
        this.typecommass = typecommass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.massnegotiation);
        hash = 23 * hash + Objects.hashCode(this.users);
        hash = 23 * hash + Objects.hashCode(this.percent);
        hash = 23 * hash + Objects.hashCode(this.commentmass);
        hash = 23 * hash + Objects.hashCode(this.typecommass);
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
        final Proposepercent other = (Proposepercent) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.massnegotiation, other.massnegotiation)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.percent, other.percent)) {
            return false;
        }
        if (!Objects.equals(this.commentmass, other.commentmass)) {
            return false;
        }
        if (!Objects.equals(this.typecommass, other.typecommass)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proposepercent{" + "id=" + id + ", massnegotiation=" + massnegotiation + ", users=" + users + ", percent=" + percent + ", commentmass=" + commentmass + ", typecommass=" + typecommass + '}';
    }




}

