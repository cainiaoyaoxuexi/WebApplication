package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Documents generated by hbm2java
 */
public class Documents  implements java.io.Serializable {


     private int codedoc;
     private String type;
     private Blob doc;
     private Date datedoc;
     private Set<Post> posts = new HashSet<Post>(0);

    public Documents() {
    }

	
    public Documents(int codedoc) {
        this.codedoc = codedoc;
    }
    public Documents(int codedoc, String type, Blob doc, Date datedoc, Set<Post> posts) {
       this.codedoc = codedoc;
       this.type = type;
       this.doc = doc;
       this.datedoc = datedoc;
       this.posts = posts;
    }
   
    public int getCodedoc() {
        return this.codedoc;
    }
    
    public void setCodedoc(int codedoc) {
        this.codedoc = codedoc;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Blob getDoc() {
        return this.doc;
    }
    
    public void setDoc(Blob doc) {
        this.doc = doc;
    }
    public Date getDatedoc() {
        return this.datedoc;
    }
    
    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }
    public Set<Post> getPosts() {
        return this.posts;
    }
    
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.codedoc;
        hash = 17 * hash + Objects.hashCode(this.type);
        hash = 17 * hash + Objects.hashCode(this.doc);
        hash = 17 * hash + Objects.hashCode(this.datedoc);
        hash = 17 * hash + Objects.hashCode(this.posts);
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
        final Documents other = (Documents) obj;
        if (this.codedoc != other.codedoc) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.doc, other.doc)) {
            return false;
        }
        if (!Objects.equals(this.datedoc, other.datedoc)) {
            return false;
        }
        if (!Objects.equals(this.posts, other.posts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documents{" + "codedoc=" + codedoc + ", type=" + type + ", doc=" + doc + ", datedoc=" + datedoc + ", posts=" + posts + '}';
    }




}


