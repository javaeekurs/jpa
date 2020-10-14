package de.drv.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.drv.jpa.model.Adresse;
import de.drv.jpa.model.Kunde;

public class Main {

	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	public static final String TABLE_NAME = "kunden";
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(TABLE_NAME);
		em = factory.createEntityManager();
		
		// Query
		// SELECT * FROM kunden;
		Query q = em.createQuery("Select k from Kunde k");
		
		List<Kunde> kunden = q.getResultList();
		
		for (Kunde k: kunden) {
			System.out.println(k.getVorname() + " " + k.getNachname());
			System.out.println(k.getAdressen().size());
			
			if (k.getAdressen().size() > 0) {
				List<Adresse> addressen = k.getAdressen();
				System.out.println(addressen.get(0).getStrasse());
			}
		}
		
		
		// SELECT k.*, a.* FROM kunden as k 
		//    LEFT JOIN addresses as a ON a.kunde = k.id
		
		System.out.println("Anzahl Kunden " + kunden.size());
		
//		createKunde("Maria", "Soundso");
		
	}
	
	public static void createKunde(String vorname, String nachname) {
		Kunde k = new Kunde();
		k.setVorname(vorname);
		k.setNachname(nachname);
	
		Adresse a = new Adresse();
		a.setStrasse("Teststr. 42");
		a.setPlz("80335");
		a.setOrt("München");
		
		a.setKunde(k);
		
		em.getTransaction().begin();
		
		// INSERT INTO kunden (vorname, nachname) VALUES ("Bernd", "Huber");
		
		// ORM -> Object Releationship Mapping
		em.persist(k);
		em.persist(a);
		// Noch mehr Sachen
		em.getTransaction().commit();
	}

}
