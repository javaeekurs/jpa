package de.drv.jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * - kein Constructor (default Constructor)
 * - serialisierbar sein
 * - Die Daten (Properties) müssen folgenden Datentyp haben
 *   - Primitive Datentypen (int, float, double, boolean, long, byte)
 *   - Serialisierbare Datentypen:
 *     - java.sql.Date, java.sql.Time etc.
 *   - Müssen als Privat / Protected definiert sein
 *   
 *   
 *   JPA (Java Persistance API)
 *   * Interfaces / Architektur
 *   
 *   * Hibernate
 *   * Eclipse Link
 */

@Entity(name="Customers")
public class Kunde implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 2^64 = long, int64
	// 2^32 => 4.290.000.000
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	private String vorname;
	
	// Das ist schlecht
	private String nachname;
	
	@Column(nullable=true)
	private String geburtsdatum;
	
	@Column(nullable=true)
	private java.sql.Date datum2;
	
	@OneToMany(mappedBy = "kunde")
	private final List<Adresse> adressen = new ArrayList<Adresse>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public java.sql.Date getDatum2() {
		return datum2;
	}

	public void setDatum2(java.sql.Date datum2) {
		this.datum2 = datum2;
	}

	public List<Adresse> getAdressen() {
		return adressen;
	}
}

/**
 * SQL Tabelle
 * 
 * CREATE TABLE Kunden ( 
 * id int AUTO_INCREMENT,
 *  vorname varchar(255),
 *   nachname varchar(255),
 *    PRIMARY KEY(id) );
 * 
 * 
 */
