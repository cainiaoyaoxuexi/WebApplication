package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.sql.Timestamp;
import java.util.Date;

/**
 * ProposeId generated by hbm2java
 */
public class ProposeId  implements java.io.Serializable {


     private String iduser;
     private short numberneg;
     private Date datepro;

    public ProposeId() {
    }

    public ProposeId(String iduser, short numberneg, Date datepro) {
       this.iduser = iduser;
       this.numberneg = numberneg;
       this.datepro = datepro;
    }
   
    public String getIduser() {
        return this.iduser;
    }
    
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
    public short getNumberneg() {
        return this.numberneg;
    }
    
    public void setNumberneg(short numberneg) {
        this.numberneg = numberneg;
    }
    public Date getDatepro() {
        return this.datepro;
    }
    
    public void setDatepro(Date datepro) {
        this.datepro = datepro;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProposeId) ) return false;
		 ProposeId castOther = ( ProposeId ) other; 
         
		 return ( (this.getIduser()==castOther.getIduser()) || ( this.getIduser()!=null && castOther.getIduser()!=null && this.getIduser().equals(castOther.getIduser()) ) )
 && (this.getNumberneg()==castOther.getNumberneg())
 && ( (this.getDatepro()==castOther.getDatepro()) || ( this.getDatepro()!=null && castOther.getDatepro()!=null && this.getDatepro().equals(castOther.getDatepro()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIduser() == null ? 0 : this.getIduser().hashCode() );
         result = 37 * result + this.getNumberneg();
         result = 37 * result + ( getDatepro() == null ? 0 : this.getDatepro().hashCode() );
         return result;
   }   

    @Override
    public String toString() {
        return "ProposeId{" + "iduser=" + iduser + ", numberneg=" + numberneg + ", datepro=" + datepro + '}';
    }


}


