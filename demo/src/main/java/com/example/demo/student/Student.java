package com.example.demo.student;

import com.example.demo.school.School;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Integer getAge()
    {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="school_id", nullable=true)
    School school;
}
