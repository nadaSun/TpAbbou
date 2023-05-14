package ma.ecommerce.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String reference;
	private String designation;
	private double price;
	private String code;

	public Article(String reference, String designation, double price) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.price = price;
	}

}
