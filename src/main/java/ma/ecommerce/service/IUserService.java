package ma.ecommerce.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.ecommerce.domaine.RoleDTO;
import ma.ecommerce.domaine.UserDTO;

public interface IUserService extends UserDetailsService {
	void save(UserDTO user);

	void save(RoleDTO role);

	List<UserDTO> getAllUsers();

	List<RoleDTO> getAllRoles();

	RoleDTO getRoleByName(String role);

	void cleanDataBase();

	boolean existsByUsername(String username);
	

	UserDTO findByUsername(String username);

	UserDTO findUserByEmail(String email);
	
	UserDTO findUserByCity(String city);

	UserDTO changeUserPassword(String username, String newPassword);
}
