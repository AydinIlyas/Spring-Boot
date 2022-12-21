package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getSchool")
    public List<School> getSchools()
    {
        return schoolService.getSchools();
    }
    @PostMapping("/addSchools")
    public void registerSchools(@RequestBody School school)
    {
        schoolService.addNewSchool(school);
    }



}
