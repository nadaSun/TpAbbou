package ma.ecommerce.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
	
	private int id;
	private String role;

	public RoleDTO(String role) {
		this.role = role;
	}
}
