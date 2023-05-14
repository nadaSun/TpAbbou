package ma.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ecommerce.dao.ArticleRepository;
import ma.ecommerce.domaine.ArticleConverter;
import ma.ecommerce.domaine.ArticleDTO;
import ma.ecommerce.service.model.Article;


;
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
    private ArticleRepository articleRepository;

	@Override
	public List<ArticleDTO> getArticles() {
		List<Article> list = articleRepository.findAll();
		return ArticleConverter.toListVo(list);
	}

	@Override
	public void save(ArticleDTO article) {
		articleRepository.save(ArticleConverter.toBo(article));

	}

	@Override
	public ArticleDTO getArticleById(Long id) {
		boolean trouve = articleRepository.existsById(id);
		if (!trouve)
			return null;
		return ArticleConverter.toVo(articleRepository.getById(id));
	}

	@Override
	public void delete(Long id) {
		articleRepository.deleteById(id);

	}

	@Override
	public List<ArticleDTO> findByPrice(Double price) {
		List<Article> list = articleRepository.findByPrice(price);
		return ArticleConverter.toListVo(list);
	}

	@Override
	public List<ArticleDTO> findBydesignation(String designation) {
		List<Article> list = articleRepository.findByDesignation(designation);
		return ArticleConverter.toListVo(list);
	}

	@Override
	public List<ArticleDTO> findByreference(String reference) {
		List<Article> list = articleRepository.findByReference(reference);
		return ArticleConverter.toListVo(list);
	}

	@Override
	public List<ArticleDTO> findBySalaryAndReference(Double price, String reference) {
		List<Article> list = articleRepository.findBySalaryAndReference(price, reference);
		return ArticleConverter.toListVo(list);
	}

	

	@Override
	public List<ArticleDTO> findAll(int pageId, int size) {
		Page<Article> result = articleRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return ArticleConverter.toListVo(result.getContent());
	}

}
