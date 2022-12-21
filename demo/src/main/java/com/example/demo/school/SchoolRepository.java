package com.example.demo.school;

import com.example.demo.student.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long>  {

//    @Query("Select s from school s where s.name=?1")
//    Optional<School> findByName(String name);

}
