package fr.eni.encheres.bo;

public class Categorie {
	
	private Integer idCat;
	private String libelle;
	
	public Categorie() {
		
	}
	
	

	/**
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @param idCat
	 * @param libelle
	 */
	public Categorie(Integer idCat, String libelle) {
		this.idCat = idCat;
		this.libelle = libelle;
	}

	/**
	 * @return the idCat
	 */
	public Integer getIdCat() {
		return idCat;
	}

	/**
	 * @param idCat the idCat to set
	 */
	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", libelle=" + libelle + "]";
	}


}
