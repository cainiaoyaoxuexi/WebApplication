package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Propose generated by hbm2java
 */
public class Propose  implements java.io.Serializable {


     private ProposeId id;
     private Partnegotiation partnegotiation;
     private Users users;
     private BigDecimal price;
     private String pricestatus;
     private Date startval;
     private Date endval;
     private BigDecimal matprice;
     private BigDecimal labprice;
     private BigDecimal otherprice;
     private String commentpart;
     private String typecompart;

    public Propose() {
    }

	
    public Propose(ProposeId id, Partnegotiation partnegotiation, Users users) {
        this.id = id;
        this.partnegotiation = partnegotiation;
        this.users = users;
    }
    public Propose(ProposeId id, Partnegotiation partnegotiation, Users users, BigDecimal price, String pricestatus, Date startval, Date endval, BigDecimal matprice, BigDecimal labprice, BigDecimal otherprice, String commentpart, String typecompart) {
       this.id = id;
       this.partnegotiation = partnegotiation;
       this.users = users;
       this.price = price;
       this.pricestatus = pricestatus;
       this.startval = startval;
       this.endval = endval;
       this.matprice = matprice;
       this.labprice = labprice;
       this.otherprice = otherprice;
       this.commentpart = commentpart;
       this.typecompart = typecompart;
    }
   
    public ProposeId getId() {
        return this.id;
    }
    
    public void setId(ProposeId id) {
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
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getPricestatus() {
        return this.pricestatus;
    }
    
    public void setPricestatus(String pricestatus) {
        this.pricestatus = pricestatus;
    }
    public Date getStartval() {
        return this.startval;
    }
    
    public void setStartval(Date startval) {
        this.startval = startval;
    }
    public Date getEndval() {
        return this.endval;
    }
    
    public void setEndval(Date endval) {
        this.endval = endval;
    }
    public BigDecimal getMatprice() {
        return this.matprice;
    }
    
    public void setMatprice(BigDecimal matprice) {
        this.matprice = matprice;
    }
    public BigDecimal getLabprice() {
        return this.labprice;
    }
    
    public void setLabprice(BigDecimal labprice) {
        this.labprice = labprice;
    }
    public BigDecimal getOtherprice() {
        return this.otherprice;
    }
    
    public void setOtherprice(BigDecimal otherprice) {
        this.otherprice = otherprice;
    }
    public String getCommentpart() {
        return this.commentpart;
    }
    
    public void setCommentpart(String commentpart) {
        this.commentpart = commentpart;
    }
    public String getTypecompart() {
        return this.typecompart;
    }
    
    public void setTypecompart(String typecompart) {
        this.typecompart = typecompart;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.partnegotiation);
        hash = 19 * hash + Objects.hashCode(this.users);
        hash = 19 * hash + Objects.hashCode(this.price);
        hash = 19 * hash + Objects.hashCode(this.pricestatus);
        hash = 19 * hash + Objects.hashCode(this.startval);
        hash = 19 * hash + Objects.hashCode(this.endval);
        hash = 19 * hash + Objects.hashCode(this.matprice);
        hash = 19 * hash + Objects.hashCode(this.labprice);
        hash = 19 * hash + Objects.hashCode(this.otherprice);
        hash = 19 * hash + Objects.hashCode(this.commentpart);
        hash = 19 * hash + Objects.hashCode(this.typecompart);
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
        final Propose other = (Propose) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.partnegotiation, other.partnegotiation)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.pricestatus, other.pricestatus)) {
            return false;
        }
        if (!Objects.equals(this.startval, other.startval)) {
            return false;
        }
        if (!Objects.equals(this.endval, other.endval)) {
            return false;
        }
        if (!Objects.equals(this.matprice, other.matprice)) {
            return false;
        }
        if (!Objects.equals(this.labprice, other.labprice)) {
            return false;
        }
        if (!Objects.equals(this.otherprice, other.otherprice)) {
            return false;
        }
        if (!Objects.equals(this.commentpart, other.commentpart)) {
            return false;
        }
        if (!Objects.equals(this.typecompart, other.typecompart)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Propose{" + "id=" + id + ", partnegotiation=" + partnegotiation + ", users=" + users + ", price=" + price + ", pricestatus=" + pricestatus + ", startval=" + startval + ", endval=" + endval + ", matprice=" + matprice + ", labprice=" + labprice + ", otherprice=" + otherprice + ", commentpart=" + commentpart + ", typecompart=" + typecompart + '}';
    }




}


