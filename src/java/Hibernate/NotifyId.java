package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0



/**
 * NotifyId generated by hbm2java
 */
public class NotifyId  implements java.io.Serializable {


     private String iduser;
     private short numberneg;

    public NotifyId() {
    }

    public NotifyId(String iduser, short numberneg) {
       this.iduser = iduser;
       this.numberneg = numberneg;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NotifyId) ) return false;
		 NotifyId castOther = ( NotifyId ) other; 
         
		 return ( (this.getIduser()==castOther.getIduser()) || ( this.getIduser()!=null && castOther.getIduser()!=null && this.getIduser().equals(castOther.getIduser()) ) )
 && (this.getNumberneg()==castOther.getNumberneg());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIduser() == null ? 0 : this.getIduser().hashCode() );
         result = 37 * result + this.getNumberneg();
         return result;
   }   

    @Override
    public String toString() {
        return "NotifyId{" + "iduser=" + iduser + ", numberneg=" + numberneg + '}';
    }


}


