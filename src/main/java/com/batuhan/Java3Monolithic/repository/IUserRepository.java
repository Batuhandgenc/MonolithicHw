package com.batuhan.Java3Monolithic.repository;


import com.batuhan.Java3Monolithic.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findOptionalByUsernameAndPassword(String username, String password);
}
