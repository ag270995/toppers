package com.studentdata.demo.service;

import com.datastax.driver.core.Session;
import com.studentdata.demo.dao.ToppersDao;
import com.studentdata.demo.model.Topper;
import com.studentdata.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    Session session;
    @Autowired
    ToppersDao toppersDao;

    public List<Student> getToppers(String state, String standard, String subject, int pageSize) {
        List<Topper> toppers = toppersDao.getToppers(state, standard, subject, pageSize);
        if (toppers == null || toppers.isEmpty()) {
            return new ArrayList<>();
        }
        List<Student> students = new ArrayList<>();
        for (Topper topper : toppers) {
            students.add(Student.builder()
                    .id(topper.getId())
                    .marks(topper.getMarks())
                    .name(topper.getStudentName())
                    .school(topper.getSchool())
                    .build());
        }
        return students;
    }

    public void saveTopper(Topper topper) {
        toppersDao.saveTopper(topper);
    }
}
