package com.dogukan.service;


import com.dogukan.domain.Role;
import com.dogukan.domain.User;
import com.dogukan.domain.enums.RoleType;
import com.dogukan.dto.RegisterUser;
import com.dogukan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor //userRepository icin yazdik const enjektesi yapmis olduk
public class UserService {
    //best practice soyledir.service katmanlari kendi arasinda yazilabilir.Fakat bir ust repository katmani sadece kendi repository olarak yazilir.
    private final UserRepository userRepository;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;


    public void saveUser(RegisterUser registerUser) {

        Role role = roleService.getRoleByType(RoleType.ROLE_STUDENT);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        User user = new User();
        user.setFirstName(registerUser.getFirstName());
        user.setUserName(registerUser.getUserName());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));//sifreleyerek setledik
        user.setRoles(roleSet);

        userRepository.save(user);
    }
}
