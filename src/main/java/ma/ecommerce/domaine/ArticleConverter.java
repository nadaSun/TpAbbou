package ma.ecommerce.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.ecommerce.service.model.Article;



public class ArticleConverter {
	public static ArticleDTO toVo(Article bo) {
		if (bo == null || bo.getId() == null)
			return null;
		ArticleDTO vo = new ArticleDTO();
		vo.setId(bo.getId());
		vo.setReference(bo.getReference());
		vo.setDesignation(bo.getDesignation());
		vo.setPrice(bo.getPrice());
		return vo;
	}

	public static Article toBo(ArticleDTO vo) {
		Article bo = new Article();
		bo.setId(vo.getId());
		bo.setReference(vo.getReference());
		bo.setDesignation(vo.getDesignation());
		bo.setPrice(vo.getPrice());
		return bo;
	}

	public static List<ArticleDTO> toListVo(List<Article> listBo) {
		List<ArticleDTO> listVo = new ArrayList<>();
		for (Article article : listBo) {
			listVo.add(toVo(article));
		}
		return listVo;
	}

}
