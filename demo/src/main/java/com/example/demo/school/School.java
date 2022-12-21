package com.example.demo.school;

import com.example.demo.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="schools")
@Data
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer student_amount;
    private String city;
}

