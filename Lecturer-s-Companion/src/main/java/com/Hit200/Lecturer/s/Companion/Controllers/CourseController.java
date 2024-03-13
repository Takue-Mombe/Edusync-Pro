package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.Courses;
import com.Hit200.Lecturer.s.Companion.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CourseApi")
public class CourseController {
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/save")
    public String saveCourse(@RequestBody Courses courses){
        courseRepo.save(courses);
        return "saved...";
    }
    @DeleteMapping("/deleteById/{id}")
    public String deletebyId(@PathVariable Long id){
        courseRepo.deleteById(id);
        return "Deleted...";
    }


}
