package ma.ecommerce.domaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;


import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ecommerce.service.model.UserRole;

@Data
@NoArgsConstructor
public class UserDTO {
	  private Long id;
	  @NotEmpty
	    private String firstName;
	  @NotEmpty
	    private String lastName;
	    @NotEmpty
	    private String username;
	    private String email;
	    private String city;
	    private String phone;
	    private String password;
	    private List<RoleDTO> roles = new ArrayList<RoleDTO>();
	    private UserRole role;
	    
	    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
	    
	   
	    private boolean accountNonExpired;
		private boolean accountNonLocked;
		private boolean credentialsNonExpired;
		private boolean enabled;
	    
	    
		public UserDTO(String firstName, String lastName, String username, String email, String city, String phone,
				String password, List<RoleDTO> roles, UserRole role,boolean accountNonExpired,
				boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.city = city;
			this.phone = phone;
			this.password = password;
			this.roles = roles;
			this.role = role;
			this.accountNonExpired=accountNonExpired;
			this.accountNonLocked=accountNonLocked;
			this.credentialsNonExpired=credentialsNonExpired;
			this.enabled=enabled;
		}
		
	
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.authorities;
		}
}

		 
	    


