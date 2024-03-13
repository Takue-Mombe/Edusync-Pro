package com.Hit200.Lecturer.s.Companion.Repositories;

import com.Hit200.Lecturer.s.Companion.Models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<user,String> {
    Optional<user> findByUsername(String username);
}
