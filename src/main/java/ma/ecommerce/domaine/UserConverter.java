package ma.ecommerce.domaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import ma.ecommerce.service.model.Role;
import ma.ecommerce.service.model.User;



public class UserConverter {
	public static UserDTO toVo(User bo) {
		if (bo == null)
			return null;
		UserDTO vo = new UserDTO();
		
		
		vo.setId(bo.getId());
		vo.setUsername(bo.getUsername());
		vo.setPassword(bo.getPassword());
		vo.setFirstName(bo.getFirstName());
		vo.setLastName(bo.getLastName());
		vo.setEmail(bo.getEmail());
		vo.setCity(bo.getCity());
		
		vo.setRoles(RoleConverter.toVoList(bo.getRoles()));
		vo.setAccountNonExpired(bo.isAccountNonExpired());
		vo.setAccountNonLocked(bo.isAccountNonLocked());
		vo.setCredentialsNonExpired(bo.isCredentialsNonExpired());
		vo.setEnabled(bo.isEnabled());
		
		vo.setAuthorities(getAuthorities(bo.getRoles()));
		
		return vo;
		
}
	private static Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
		roles.forEach(r -> springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getRole())));
		return springSecurityAuthorities;
	}
	
	
	public static User toBo(UserDTO vo) {
		if (vo == null)
			return null;
		User bo = new User();
		if (vo.getId() != null)
			bo.setId(vo.getId());
		bo.setUsername(vo.getUsername());
		bo.setPassword(vo.getPassword());
		
		bo.setFirstName(bo.getFirstName());
		bo.setLastName(bo.getLastName());
		bo.setEmail(bo.getEmail());
		bo.setCity(bo.getCity());
		bo.setRoles(RoleConverter.toBoList(vo.getRoles()));
		bo.setAccountNonExpired(vo.isAccountNonExpired());
		bo.setAccountNonLocked(vo.isAccountNonLocked());
		bo.setCredentialsNonExpired(vo.isCredentialsNonExpired());
		bo.setEnabled(vo.isEnabled());
		return bo;
	}

	public static List<UserDTO> toVoList(List<User> boList) {
		if (boList == null || boList.isEmpty())
			return null;
		List<UserDTO> voList = new ArrayList<>();
		for (User user : boList) {
			voList.add(toVo(user));
		}
		return voList;
	}

	public static List<User> toBoList(List<UserDTO> voList) {
		if (voList == null || voList.isEmpty())
			return null;
		List<User> boList = new ArrayList<>();
		for (UserDTO userVo : voList) {
			boList.add(toBo(userVo));
		}
		return boList;
	}
}
