package com.dogukan.service;

import com.dogukan.domain.Role;
import com.dogukan.domain.enums.RoleType;
import com.dogukan.exception.ResourceNotFoundException;
import com.dogukan.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleByType(RoleType roleAdmin) {
        return roleRepository.findByType(roleAdmin).
                orElseThrow(() -> new ResourceNotFoundException("Role Type is not found!"));
    }
}
