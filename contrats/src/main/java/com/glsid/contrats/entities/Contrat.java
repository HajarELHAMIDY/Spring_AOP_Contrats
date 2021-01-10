package com.glsid.contrats.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date date;
    private double montant;
    private String nomClient;
    private String cinClient;
    
	public Contrat() {
		
	}
	public Contrat(Long id, String titre, Date date, double montant, String nomClient, String cinClient) {
		super();
		this.id = id;
		this.titre = titre;
		this.date = date;
		this.montant = montant;
		this.nomClient = nomClient;
		this.cinClient = cinClient;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getCinClient() {
		return cinClient;
	}
	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}
    
}
