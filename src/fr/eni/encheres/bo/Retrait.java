package fr.eni.encheres.bo;

public class Retrait {
	
	private Articles article;
	private Integer articleId;
	private String rue;
	private Integer cdp;
	private String ville;
	
	
	public Retrait() {
		
	}


	/**
	 * @param article
	 * @param rue
	 * @param cdp
	 * @param ville
	 */
	public Retrait(Articles article, String rue, Integer cdp, String ville) {
		this.article = article;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
	}
	
	/**
	 * @param articleId
	 * @param rue
	 * @param cdp
	 * @param ville
	 */
	public Retrait(Integer articleId, String rue, Integer cdp, String ville) {
		this.articleId = articleId;
		this.rue = rue;
		this.cdp = cdp;
		this.ville = ville;
	}


	/**
	 * @return the article
	 */
	public Articles getArticle() {
		return article;
	}


	/**
	 * @param article the article to set
	 */
	public void setArticle(Articles article) {
		this.article = article;
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
	 * @return the articleId
	 */
	public Integer getArticleId() {
		return articleId;
	}


	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}


	@Override
	public String toString() {
		return "Retrait [article=" + article + ", articleId=" + articleId + ", rue=" + rue + ", cdp=" + cdp + ", ville="
				+ ville + "]";
	}

	
	
}
