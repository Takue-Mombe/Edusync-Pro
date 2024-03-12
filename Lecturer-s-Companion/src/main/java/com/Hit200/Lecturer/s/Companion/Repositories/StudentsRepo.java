package com.Hit200.Lecturer.s.Companion.Repositories;

import com.Hit200.Lecturer.s.Companion.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Students,String>{
}
