package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.CourseMarks;
import com.Hit200.Lecturer.s.Companion.Repositories.CourseMarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marks")
public class CourseMarkController {

    @Autowired
    private CourseMarksRepo courseMarksRepo;

    @PostMapping("/save")
    public String saveMarks(@RequestBody CourseMarks courseMarks){
        courseMarksRepo.save(courseMarks);
        return "saved";
    }




}
