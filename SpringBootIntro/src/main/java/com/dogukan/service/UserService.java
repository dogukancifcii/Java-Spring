package com.dogukan.service;

import com.dogukan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //userRepository icin yazdik const enjektesi yapmis olduk
public class UserService {

    private final UserRepository userRepository;
}
