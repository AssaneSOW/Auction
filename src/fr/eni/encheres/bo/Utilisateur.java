package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Utilisateur {
	
	/**
	 * classe disposant des attributs de la table correspondante,
	 * un constructeur vide, un constructeur sans et un autre avec id
	 * getters et setters et méthode toString();
	 */
	
	private Integer idUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private Integer tel;
	private String rue;
	private Integer cdp;
	private String ville;
	private String mdp;
	private Integer credit = 0;
	private boolean admin = false;
	private List<Articles> articles;
	
	public Utilisateur() {
		articles = new ArrayList<>();
	}

	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param cdp
	 * @param ville
	 * @param mdp
	 * @param credit
	 * @param admin
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, Integer tel, String rue, Integer cdp,
			String ville, String mdp, Integer credit, boolean admin) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}

	/**
	 * @param id
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param cdp
	 * @param ville
	 * @param mdp
	 * @param credit
	 * @param admin
	 */
	public Utilisateur(Integer id, String pseudo, String nom, String prenom, String email, Integer tel, String rue, Integer cdp,
			String ville, String mdp, Integer credit, boolean admin) {
		this.idUtilisateur = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}
	
	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param cdp
	 * @param ville
	 * @param mdp
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, Integer tel, String rue, Integer cdp,
			String ville, String mdp) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
		this.mdp = mdp;
	}

	

	/**
	 * @param idUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param cdp
	 * @param ville
	 * @param mdp
	 */
	public Utilisateur(Integer idUtilisateur, String pseudo, String nom, String prenom, String email, Integer tel,
			String rue, Integer cdp, String ville, String mdp) {
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
		this.mdp = mdp;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return idUtilisateur;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.idUtilisateur = id;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public Integer getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(Integer tel) {
		this.tel = tel;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the cdp
	 */
	public Integer getCdp() {
		return cdp;
	}

	/**
	 * @param cdp the cdp to set
	 */
	public void setCdp(Integer cdp) {
		this.cdp = cdp;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the credit
	 */
	public Integer getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	/**
	 * @return the admin
	 */
	public boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	//méthodes propres à la liste articles
	
	public Articles getArticle(int index) {
		return articles.get(index);
	}
	
	public List<Articles> getArticles(){
		return articles;
	}
	
	public void ajoutArticle(Integer idArticle, String nomArticle, String description, Categorie cat, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, Integer prixInitial, Integer prixVente, String img, boolean vendu, Utilisateur vendeur,
			Utilisateur acheteur, Retrait retrait, Encheres enchere) {
		Articles ajoutArticle = new Articles(idArticle, nomArticle, description, cat, dateDebutEncheres, dateFinEncheres,
				prixInitial, prixVente, img, vendu, vendeur, acheteur, retrait, enchere);
		articles.add(ajoutArticle);
	}
	
	public void retraitArticle(int index) {
		articles.remove(index);
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", tel=" + tel + ", rue=" + rue + ", cdp=" + cdp + ", ville=" + ville
				+ ", mdp=" + mdp + ", credit=" + credit + ", admin=" + admin + ", articles=" + articles + "]";
	}
	
	
	
	
}
