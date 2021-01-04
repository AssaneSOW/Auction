package fr.eni.encheres.bo;

import java.time.LocalDateTime;

public class Articles {
	
	/**
	 * classe disposant des attributs de la table correspondante,
	 * un constructeur vide, un constructeur sans et un autre avec id
	 * getters et setters et méthode toString();
	 */
	
	private Integer idArticle;
	private String nomArticle;
	private String description;
	private Categorie cat;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private Integer prixInitial;
	private Integer prixVente;
	private String img;
	private boolean vendu = false;
	private Utilisateur vendeur;
	private Utilisateur acheteur;
	private Retrait retrait;
	private Encheres enchere;
	
	public Articles() {
		
	}

	/**
	 * @param idArticle
	 * @param nomArticle
	 * @param description
	 * @param cat
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param img
	 * @param vendu
	 * @param vendeur
	 * @param acheteur
	 * @param retrait
	 * @param enchere
	 */
	public Articles(Integer idArticle, String nomArticle, String description, Categorie cat,
			LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente,
			String img, boolean vendu, Utilisateur vendeur, Utilisateur acheteur, Retrait retrait, Encheres enchere) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.cat = cat;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.img = img;
		this.vendu = vendu;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
		this.retrait = retrait;
		this.enchere = enchere;
	}

	/**
	 * @param nomArticle
	 * @param description
	 * @param cat
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param img
	 * @param vendu
	 * @param vendeur
	 * @param acheteur
	 * @param retrait
	 * @param enchere
	 */
	public Articles(String nomArticle, String description, Categorie cat, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, String img, boolean vendu,
			Utilisateur vendeur, Utilisateur acheteur, Retrait retrait, Encheres enchere) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.cat = cat;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.img = img;
		this.vendu = vendu;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
		this.retrait = retrait;
		this.enchere = enchere;
	}

	/**
	 * @param nomArticle
	 * @param description
	 * @param cat
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param img
	 * @param vendeur
	 * @param retrait
	 */
	public Articles(String nomArticle, String description, Categorie cat, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, String img, Utilisateur vendeur, Utilisateur acheteur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.cat = cat;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.img = img;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
	}
	
	public Articles(Integer idArticle, String nomArticle, String description, Categorie cat, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, String img, Utilisateur vendeur, Utilisateur acheteur) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.cat = cat;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.img = img;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
	}

	/**
	 * @return the idArticle
	 */
	public Integer getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cat
	 */
	public Categorie getCat() {
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	/**
	 * @return the dateDebutEncheres
	 */
	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * @return the dateFinEncheres
	 */
	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	/**
	 * @return the prixInitial
	 */
	public Integer getPrixInitial() {
		return prixInitial;
	}

	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	/**
	 * @return the prixVente
	 */
	public Integer getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the vendu
	 */
	public boolean getVendu() {
		return vendu;
	}

	/**
	 * @param vendu the vendu to set
	 */
	public void setVendu(boolean vendu) {
		this.vendu = vendu;
	}

	/**
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}

	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	/**
	 * @return the acheteur
	 */
	public Utilisateur getAcheteur() {
		return acheteur;
	}

	/**
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}

	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	/**
	 * @return the enchere
	 */
	public Encheres getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(Encheres enchere) {
		this.enchere = enchere;
	}

	@Override
	public String toString() {
		return "Articles [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", cat=" + cat + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres
				+ ", prixInitial=" + prixInitial + ", prixVente=" + prixVente + ", img=" + img + ", vendu=" + vendu
				+ ", vendeur=" + vendeur + ", acheteur=" + acheteur + ", retrait=" + retrait + ", enchere=" + enchere
				+ "]";
	}


}
