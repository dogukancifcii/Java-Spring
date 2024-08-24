package com.dogukan.security;

import com.dogukan.domain.Role;
import com.dogukan.domain.User;
import com.dogukan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//bu class spring security icin istenilen yapiya cevirdigimiz yapidir.
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    //amac: UserDetails <--> User, GrantedAuthority<-->Role
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found by username: " + username));

        return new org.springframework.security.core.userdetails.
                User(user.getUserName(), user.getPassword(), buildGrantedAuthorities(user.getRoles()));
        //kendi userimizin bilgileri ile securitynin userini(userdetails) olusturduk
    }

    //bizim userimizin rolleri var -->grantedauthoritylere cevirelim
    //simplegrantedauthority --> security nin tanidigi rolleri
    private List<SimpleGrantedAuthority> buildGrantedAuthorities(Set<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            //enum icindeki rolleri string olarak almis olduk
            authorities.add(new SimpleGrantedAuthority(role.getType().name()));
        }
        //SimpleGrantedAuthority nin constructorina parametre olarak
        //rollerimiz type nin name ini vererek rollerden grantedauthority elde ettik.
        return authorities;
    }
}
