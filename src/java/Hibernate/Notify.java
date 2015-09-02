package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0

import java.util.Objects;




/**
 * Notify generated by hbm2java
 */
public class Notify  implements java.io.Serializable {


     private NotifyId id;
     private Partnegotiation partnegotiation;
     private Users users;
     private String comstatus;
     private String pricestatus;
     private String newpartnego;

    public Notify() {
    }

	
    public Notify(NotifyId id, Partnegotiation partnegotiation, Users users) {
        this.id = id;
        this.partnegotiation = partnegotiation;
        this.users = users;
    }
    public Notify(NotifyId id, Partnegotiation partnegotiation, Users users, String comstatus, String pricestatus, String newpartnego) {
       this.id = id;
       this.partnegotiation = partnegotiation;
       this.users = users;
       this.comstatus = comstatus;
       this.pricestatus = pricestatus;
       this.newpartnego = newpartnego;
    }
   
    public NotifyId getId() {
        return this.id;
    }
    
    public void setId(NotifyId id) {
        this.id = id;
    }
    public Partnegotiation getPartnegotiation() {
        return this.partnegotiation;
    }
    
    public void setPartnegotiation(Partnegotiation partnegotiation) {
        this.partnegotiation = partnegotiation;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getComstatus() {
        return this.comstatus;
    }
    
    public void setComstatus(String comstatus) {
        this.comstatus = comstatus;
    }
    public String getPricestatus() {
        return this.pricestatus;
    }
    
    public void setPricestatus(String pricestatus) {
        this.pricestatus = pricestatus;
    }
    public String getNewpartnego() {
        return this.newpartnego;
    }
    
    public void setNewpartnego(String newpartnego) {
        this.newpartnego = newpartnego;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.partnegotiation);
        hash = 29 * hash + Objects.hashCode(this.users);
        hash = 29 * hash + Objects.hashCode(this.comstatus);
        hash = 29 * hash + Objects.hashCode(this.pricestatus);
        hash = 29 * hash + Objects.hashCode(this.newpartnego);
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
        final Notify other = (Notify) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.partnegotiation, other.partnegotiation)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.comstatus, other.comstatus)) {
            return false;
        }
        if (!Objects.equals(this.pricestatus, other.pricestatus)) {
            return false;
        }
        if (!Objects.equals(this.newpartnego, other.newpartnego)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notify{" + "id=" + id + ", partnegotiation=" + partnegotiation + ", users=" + users + ", comstatus=" + comstatus + ", pricestatus=" + pricestatus + ", newpartnego=" + newpartnego + '}';
    }




}


