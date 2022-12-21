package com.example.demo.school;

import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    public List<School> getSchools()
    {
        return schoolRepository.findAll();
    }
    public void addNewSchool(School school)
    {
//        Optional<School> schoolOptional=schoolRepository.findByName(school.getName());
//        if(schoolOptional.isPresent())
//        {
//            throw new IllegalStateException("This school already exists");
//        }
        schoolRepository.save(school);
    }

}
