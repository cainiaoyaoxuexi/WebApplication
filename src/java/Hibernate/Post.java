package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0

import java.util.Objects;




/**
 * Post generated by hbm2java
 */
public class Post  implements java.io.Serializable {


     private PostId id;
     private Partnegotiation partnegotiation;
     private Documents documents;
     private Users users;

    public Post() {
    }

    public Post(PostId id, Partnegotiation partnegotiation, Documents documents, Users users) {
       this.id = id;
       this.partnegotiation = partnegotiation;
       this.documents = documents;
       this.users = users;
    }
   
    public PostId getId() {
        return this.id;
    }
    
    public void setId(PostId id) {
        this.id = id;
    }
    public Partnegotiation getPartnegotiation() {
        return this.partnegotiation;
    }
    
    public void setPartnegotiation(Partnegotiation partnegotiation) {
        this.partnegotiation = partnegotiation;
    }
    public Documents getDocuments() {
        return this.documents;
    }
    
    public void setDocuments(Documents documents) {
        this.documents = documents;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.partnegotiation);
        hash = 79 * hash + Objects.hashCode(this.documents);
        hash = 79 * hash + Objects.hashCode(this.users);
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
        final Post other = (Post) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.partnegotiation, other.partnegotiation)) {
            return false;
        }
        if (!Objects.equals(this.documents, other.documents)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", partnegotiation=" + partnegotiation + ", documents=" + documents + ", users=" + users + '}';
    }




}


