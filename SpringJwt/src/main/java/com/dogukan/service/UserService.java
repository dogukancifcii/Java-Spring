package com.dogukan.service;


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


}
