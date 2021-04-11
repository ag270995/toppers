package com.studentdata.demo.controller;

import com.studentdata.demo.model.Topper;
import com.studentdata.demo.pojo.Response;
import com.studentdata.demo.pojo.Student;
import com.studentdata.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppers")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/{state}/{class}/{subject}")
    public Response getToppers(@PathVariable("state") String state,
                               @PathVariable(value="class") String standard,
                               @PathVariable(value="subject") String subject,
                               @RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize) {
        return Response.getInstance("Success", studentService.getToppers(state, standard, subject, pageSize));
    }

    @PostMapping
    public Response saveTopper(@RequestBody Topper topper) {
       studentService.saveTopper(topper);
        return Response.getInstance("Success");
    }


}
