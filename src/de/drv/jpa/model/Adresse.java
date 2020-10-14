package de.drv.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Id des Kunden
	private Kunde kunde;
	
	private String strasse;
	
	private String plz;
	
	private String ort;
	
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	
	

}
