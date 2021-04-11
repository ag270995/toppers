package com.studentdata.demo.model;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

@Data
@Table(keyspace = "assignment", name = "toppers")
public class Topper {
    @PartitionKey(0)
    private String state;
    @PartitionKey(1)
    private String standard;
    @PartitionKey(2)
    private String subject;
    @ClusteringColumn
    private int marks;
    @ClusteringColumn(1)
    private int id;
    @Column(name = "student_name")
    private String studentName;
    private String school;
}
