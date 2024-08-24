package com.dogukan.service;

import com.dogukan.domain.Role;
import com.dogukan.domain.User;
import com.dogukan.domain.enums.RoleType;
import com.dogukan.dto.UserRequest;
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

    public void saveUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setUserName(userRequest.getUserName());
        //passwordu sifreleyelim DB ye kaydedelim.
        String password = userRequest.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        //DTO daki password sifrelendi
        user.setPassword(encodedPassword);


        //rolunun verilmesi
        Set<Role> roleSet = new HashSet<>();
        Role role = roleService.getRoleByType(RoleType.ROLE_ADMIN);
        //NOT:genelde kullanicilara default olarak en dusuk yetkideki rol verilir.Yani ROLE_ADMIN verme sebebimiz Student control classinda PreAuthorizede ROLE_ADMIN verdigimiz icin.
        roleSet.add(role);
        user.setRoles(roleSet);
        userRepository.save(user);
    }
}
