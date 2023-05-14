package ma.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ecommerce.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByUsername(String username);

}
