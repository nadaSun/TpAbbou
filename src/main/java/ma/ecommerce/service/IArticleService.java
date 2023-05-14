package ma.ecommerce.service;

import java.util.List;

import ma.ecommerce.domaine.ArticleDTO;



public interface IArticleService {
	List<ArticleDTO> getArticles();
	void save(ArticleDTO article);
	ArticleDTO getArticleById(Long id);
	void delete(Long id);
	List<ArticleDTO> findByPrice(Double price);
	List<ArticleDTO> findBydesignation(String designation);
	List<ArticleDTO> findByreference(String reference);
	
	List<ArticleDTO> findBySalaryAndReference(Double price, String reference);
	
	//Pour la pagination
	List<ArticleDTO> findAll(int pageId, int size);
	
}


