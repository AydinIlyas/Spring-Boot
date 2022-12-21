package com.example.demo.student;

import com.example.demo.school.School;
import com.example.demo.school.SchoolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email taken");
        }
        if(student.getSchool()!=null)
        {
            Optional<School> schoolOptional=schoolRepository.findById(student.getSchool().getId());
            if(!schoolOptional.isPresent())
            {
                throw new IllegalStateException("School doesn't exist.");
            }
        }
        studentRepository.save(student);
    }
    public void deleteStudent(Long id)
    {
        Optional<Student> studentOptional=studentRepository.findStudentsById(id);
        if(!studentOptional.isPresent())
        {
            throw new IllegalStateException("Student doesn't exist");
        }
        studentRepository.delete(studentOptional.get());
    }

    @Transactional
    public void updateStudent(Long studentId,Student studentData) {
        Student student=studentRepository.findStudentsById(studentId).orElseThrow(()-> new IllegalStateException("student doesn't exist"));
        if(studentData.getName()!=null&&studentData.getName().length()>0&& !Objects.equals(student.getName(),studentData.getName()))
        {
            student.setName(studentData.getName());
        }
        if(studentData.getEmail()!=null&&studentData.getEmail().length()>0&&!Objects.equals(student.getEmail(),studentData.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentData.getEmail());
            if (!studentOptional.isPresent()) {
                student.setEmail(studentData.getEmail());
            } else {
                throw new IllegalStateException("Diese email adresse gehort jemand anderem!");
            }
        }

        if(!Objects.equals(studentData.getSchool(),student.getSchool()))
        {
            Optional<School> schoolOptional=schoolRepository.findById(studentData.school.getId());
            if(schoolOptional.isPresent())
            {
                student.setSchool(studentData.school);
            }
            else{
                throw new IllegalStateException("No such a school");
            }
        }

        studentRepository.save(student);

    }
}
