package ma.ecommerce.domaine;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ArticleDTO {

	private Long id;
	@NotEmpty(message = "Le reference  ne peut pas être vide")
	private String reference;
	@NotEmpty(message = "La designation  ne peut pas être vide")

	private String designation;
	@Max(value = 15000, message = "Le salaire ne doit pas dépasser 15000 ")
	private Double price;
	
	
	public ArticleDTO() {
		super();
	}
	
	public ArticleDTO(Long id, String reference,String designation, Double price) {
		this(reference,designation,price);
		this.id = id;
	}

	public ArticleDTO( String reference,String designation, Double price) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.price = price;
	}
	
	
	
	

}
