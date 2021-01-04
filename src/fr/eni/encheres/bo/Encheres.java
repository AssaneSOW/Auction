package fr.eni.encheres.bo;

import java.sql.Date;

public class Encheres {
	
	private Integer idArticle;
	private Date dateEnchere;
	private float montantEnchere;
	
	
	public Encheres() {
		
	}

	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param idArticle
	 */
	public Encheres(Integer idArticle, Date dateEnchere, float montantEnchere) {
		this.idArticle = idArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
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
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public float getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Encheres [idArticle=" + idArticle + ", dateEnchere=" + dateEnchere + ", montantEnchere="
				+ montantEnchere + "]";
	}
	
}
