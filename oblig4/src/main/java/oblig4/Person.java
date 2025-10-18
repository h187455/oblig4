package oblig4;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    @Size(min=2, max=20, message="Fornavn må inneholde fra 2 til 20")
    @NotNull(message = "Fornavn er obligatorisk")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\- ]*$", message = "Fornavn må starte med stor bokstav og kan bare inneholde bokstaver, bindestreke og mellomrom")
    private String fornavn;

    @Size(min = 2, max = 20, message = "Etternavn må inneholde fra 2 til 20")
    @NotNull(message = "Etternavn er obligatorisk")
    @Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]*$", message = "Etternavn må starte med stor bokstav og kan bare inneholde bokstaver og bindestreker")
    private String etternavn;

    @Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må være 8 siffer")
    @NotNull(message = "Mobilnummer er obligatorisk")
    private String mobilnummer;

    @Size(min = 8, message = "Passord må ha minst 8 tegn")
    @NotNull(message = "Passord er obligatorisk")
    private String passord;
    
    @NotNull(message = "Kjønn er obligatorisk")
    @Pattern(regexp = "^(mann|kvinner)$", message = "kjønn må være enten 'mann' eller 'kvinner'")
    private String kjonn; 
    
    public Person(String fornavn, String etternavn, String mobilnummer, String passord, String kjonn) {
    	this.fornavn = fornavn; 
    	this.etternavn = etternavn; 
    	this.mobilnummer = mobilnummer; 
    	this.passord = passord; 
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
    
    public String getPassord() {
    	return passord; 
    }
    
    public void setPassord(String passord) {
    	this.passord = passord; 
    }
    
    public String getKjonn() {
    	return kjonn; 
    }
    
    public void setKjonn(String kjonn) {
    	this.kjonn = kjonn; 
    }
}
