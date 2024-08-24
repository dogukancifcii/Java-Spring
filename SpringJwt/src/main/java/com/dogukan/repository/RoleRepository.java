package com.dogukan.repository;

import com.dogukan.domain.Role;
import com.dogukan.domain.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    //Role tipini aldik
    Optional<Role> findByType(RoleType type);

}
