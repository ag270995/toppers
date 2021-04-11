package com.studentdata.demo.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Student {
    int id;
    int marks;
    String name;
    String school;

}
