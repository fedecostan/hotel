package com.sistemas.facturacion.repository.security;

import com.sistemas.facturacion.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserUsername(String username);

}
