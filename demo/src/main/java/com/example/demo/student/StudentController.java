package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/get")
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping("/add")
    public void registerNewStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="/delete")
    public void deleteStudentById(@RequestBody Long id){studentService.deleteStudent(id);}

    @PutMapping(path="/update/{id}")
    public void updateStudent(@PathVariable("id") Long studentId,
                              //@RequestParam(required = false) String name,
                              //@RequestParam(required = false) String email
                                @RequestBody(required = true) Student studentData) {
        studentService.updateStudent(studentId,studentData);
    }



}
