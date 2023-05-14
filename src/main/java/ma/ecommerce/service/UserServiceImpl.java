package ma.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ecommerce.dao.ArticleRepository;
import ma.ecommerce.dao.RoleRepository;
import ma.ecommerce.dao.UserRepository;
import ma.ecommerce.domaine.RoleConverter;
import ma.ecommerce.domaine.RoleDTO;
import ma.ecommerce.domaine.UserConverter;
import ma.ecommerce.domaine.UserDTO;
import ma.ecommerce.service.exception.BusinessException;
import ma.ecommerce.service.model.Role;
import ma.ecommerce.service.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ArticleRepository articleRepository;
	
	   @Autowired
	    private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserConverter.toVo(userRepository.findByUsername(username));
	}
	

	@Override
	public void save(UserDTO userVo) {
		User user = UserConverter.toBo(userVo);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> rolesPersist = new ArrayList<>();
		for (Role role : user.getRoles()) {
			Role userRole = roleRepository.findByRole(role.getRole()).get(0);
			rolesPersist.add(userRole);
		}
		user.setRoles(rolesPersist);
		userRepository.save(user);
	}

	

	@Override
	public void save(RoleDTO roleVo) {
		roleRepository.save(RoleConverter.toBo(roleVo));

	}

	@Override
	public List<UserDTO> getAllUsers() {
		return UserConverter.toVoList(userRepository.findAll());
	
	}

	@Override
	public List<RoleDTO> getAllRoles() {
		return RoleConverter.toVoList(roleRepository.findAll());
	}

	@Override
	public RoleDTO getRoleByName(String role) {
		return RoleConverter.toVo(roleRepository.findByRole(role).get(0));
	}

	@Override
	public void cleanDataBase() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		articleRepository.deleteAll();

	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public UserDTO findByUsername(String username) {
		if (username == null || username.trim().equals(""))
			throw new BusinessException("login is empty !!");

		User bo = userRepository.findByUsername(username);

		if (bo == null)
			throw new BusinessException("No user with this login");

		UserDTO vo = UserConverter.toVo(bo);
		return vo;
	}

	@Override
	public UserDTO findUserByEmail(String email) {
		if (email == null || email.trim().equals(""))
			throw new BusinessException("email is empty !!");

		User bo = userRepository.findByUsername(email);

		if (bo == null)
			throw new BusinessException("No eamil with this login");

		UserDTO vo = UserConverter.toVo(bo);
		return vo;
	}
	
	
@Autowired
	@Override
	public UserDTO changeUserPassword(String username, String newPassword) {
		 User user = userRepository.findByUsername(username);
		    user.setPassword(passwordEncoder.encode(newPassword));
		    User updatedUser = userRepository.save(user);
		    return new UserDTO(updatedUser.getUsername(), updatedUser.getEmail(), updatedUser.getRoles());
		   
		}
}
