package fr.adaming.entities;

import java.math.BigDecimal;

public class Action {
	
	
	private String nom;
	
	private BigDecimal cours;

	/**
	 * 
	 */
	public Action() {
		super();
	}

	/**
	 * @param nom
	 * @param cours
	 */
	public Action(String nom, BigDecimal cours) {
		super();
		this.nom = nom;
		this.cours = cours;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the cours
	 */
	public BigDecimal getCours() {
		return cours;
	}

	/**
	 * @param cours the cours to set
	 */
	public void setCours(BigDecimal cours) {
		this.cours = cours;
	}
	
	
	

}
