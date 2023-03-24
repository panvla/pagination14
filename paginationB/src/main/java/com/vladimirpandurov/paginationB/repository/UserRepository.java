package com.vladimirpandurov.paginationB.repository;

import com.vladimirpandurov.paginationB.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameContaining(String name, Pageable pageable);

}
