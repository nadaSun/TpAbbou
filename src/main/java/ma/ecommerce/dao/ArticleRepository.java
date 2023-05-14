package ma.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ecommerce.service.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByDesignation(String designation);
	List<Article> findByPrice(Double Price);
	List<Article> findByReference(String reference);
	
	List<Article> findBySalaryAndReference(Double Price, String reference);

}


