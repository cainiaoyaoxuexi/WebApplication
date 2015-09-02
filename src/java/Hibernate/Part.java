package Hibernate;
// Generated 27 mars 2015 15:50:02 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Part generated by hbm2java
 */
public class Part  implements java.io.Serializable {


     private String numberpart;
     private Technology technology;
     private String description;
     private String plant;
     private String unit;
     private String acprogamme;
     private String workshop;
     private String refcousine;
     private String rawmaterial;
     private Set<Partnegotiation> partnegotiations = new HashSet<Partnegotiation>(0);

    public Part() {
    }

	
    public Part(String numberpart) {
        this.numberpart = numberpart;
    }
    public Part(String numberpart, Technology technology, String description, String plant, String unit, String acprogamme, String workshop, String refcousine, String rawmaterial, Set<Partnegotiation> partnegotiations) {
       this.numberpart = numberpart;
       this.technology = technology;
       this.description = description;
       this.plant = plant;
       this.unit = unit;
       this.acprogamme = acprogamme;
       this.workshop = workshop;
       this.refcousine = refcousine;
       this.rawmaterial = rawmaterial;
       this.partnegotiations = partnegotiations;
    }
   
    public String getNumberpart() {
        return this.numberpart;
    }
    
    public void setNumberpart(String numberpart) {
        this.numberpart = numberpart;
    }
    public Technology getTechnology() {
        return this.technology;
    }
    
    public void setTechnology(Technology technology) {
        this.technology = technology;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlant() {
        return this.plant;
    }
    
    public void setPlant(String plant) {
        this.plant = plant;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getAcprogamme() {
        return this.acprogamme;
    }
    
    public void setAcprogamme(String acprogamme) {
        this.acprogamme = acprogamme;
    }
    public String getWorkshop() {
        return this.workshop;
    }
    
    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
    public String getRefcousine() {
        return this.refcousine;
    }
    
    public void setRefcousine(String refcousine) {
        this.refcousine = refcousine;
    }
    public String getRawmaterial() {
        return this.rawmaterial;
    }
    
    public void setRawmaterial(String rawmaterial) {
        this.rawmaterial = rawmaterial;
    }
    public Set<Partnegotiation> getPartnegotiations() {
        return this.partnegotiations;
    }
    
    public void setPartnegotiations(Set<Partnegotiation> partnegotiations) {
        this.partnegotiations = partnegotiations;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.numberpart);
        hash = 13 * hash + Objects.hashCode(this.technology);
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.plant);
        hash = 13 * hash + Objects.hashCode(this.unit);
        hash = 13 * hash + Objects.hashCode(this.acprogamme);
        hash = 13 * hash + Objects.hashCode(this.workshop);
        hash = 13 * hash + Objects.hashCode(this.refcousine);
        hash = 13 * hash + Objects.hashCode(this.rawmaterial);
        hash = 13 * hash + Objects.hashCode(this.partnegotiations);
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
        final Part other = (Part) obj;
        if (!Objects.equals(this.numberpart, other.numberpart)) {
            return false;
        }
        if (!Objects.equals(this.technology, other.technology)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.plant, other.plant)) {
            return false;
        }
        if (!Objects.equals(this.unit, other.unit)) {
            return false;
        }
        if (!Objects.equals(this.acprogamme, other.acprogamme)) {
            return false;
        }
        if (!Objects.equals(this.workshop, other.workshop)) {
            return false;
        }
        if (!Objects.equals(this.refcousine, other.refcousine)) {
            return false;
        }
        if (!Objects.equals(this.rawmaterial, other.rawmaterial)) {
            return false;
        }
        if (!Objects.equals(this.partnegotiations, other.partnegotiations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Part{" + "numberpart=" + numberpart + ", technology=" + technology + ", description=" + description + ", plant=" + plant + ", unit=" + unit + ", acprogamme=" + acprogamme + ", workshop=" + workshop + ", refcousine=" + refcousine + ", rawmaterial=" + rawmaterial + ", partnegotiations=" + partnegotiations + '}';
    }




}


