package com.dogukan.repository;

import com.dogukan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Username password eslesmesini kontrol edecegiz
    Optional<User> findByUserName(String username);


}
