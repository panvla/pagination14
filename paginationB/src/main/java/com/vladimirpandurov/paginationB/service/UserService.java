package com.vladimirpandurov.paginationB.service;

import com.vladimirpandurov.paginationB.domain.User;
import com.vladimirpandurov.paginationB.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(String name, int page, int size){
        log.info("Vredonst imena" + name);
        return this.userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }

}
