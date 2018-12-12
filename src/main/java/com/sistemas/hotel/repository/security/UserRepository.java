package com.sistemas.hotel.repository.security;

import com.sistemas.hotel.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserUsername(String username);

}
