package oblig4;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(schema = "deltager")
public class Deltager {
	
   @Id
    private String fornavn;
    private String etternavn;
    private String mobilnummer;
    private String hash;
    private String salt; 
    private String kjonn; 
    
    public Deltager(String fornavn, String etternavn, String mobilnummer, String hash, String salt, String kjonn) {
    	this.fornavn = fornavn; 
    	this.etternavn = etternavn; 
    	this.mobilnummer = mobilnummer;
    	this.hash = hash; 
    	this.salt = salt; 
    	this.kjonn = kjonn; 
    }
    
 // Gettere og Settere
    public String getFornavn() {
    	return fornavn; 
    }
    
    public void setFornavn(String fornavn) {
    	this.fornavn = fornavn; 
    }
    
    public String getEtternavn() {
    	return etternavn; 
    }
    
    public void setEtternavn(String etternavn) {
    	this.etternavn = etternavn; 
    }
    
    public String getMobilnummer() {
    	return mobilnummer; 
    }
    
    public void setMobilnummer(String mobilnummer) {
    	this.mobilnummer = mobilnummer; 
    }
    
    public String gethash() {
    	return hash;
    }
    
    public void sethash(String hash) {
    	this.hash = hash; 
    }
    
    public String getsalt() {
    	return salt; 
    }
    
    public void setsalt(String salt) {
    	this.salt = salt; 
    }
    
    public String getKjonn() {
    	return kjonn; 
    }
    
    public void setKjonn(String kjonn) {
    	this.kjonn = kjonn; 
    }
    
    @Override
    public boolean equals(Object o) {
    	if(this == o) return true; 
    	if(o == null || getClass() != o.getClass()) return false; 
    	Deltager deltager = (Deltager) o;
    	return Objects.equals(mobilnummer, deltager.mobilnummer)&&
    		   Objects.equals(fornavn, deltager.fornavn)&&
    		   Objects.equals(etternavn, deltager.etternavn)&&
    		   Objects.equals(hash, deltager.hash)&&
    		   Objects.equals(salt, deltager.salt)&&
    		   Objects.equals(kjonn, deltager.kjonn); 
    	
    }
    @Override
    public int hashCode() {
    	return Objects.hash(mobilnummer, fornavn, etternavn, hash, salt, kjonn); 
    }
}
