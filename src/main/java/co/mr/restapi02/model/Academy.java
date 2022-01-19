package co.mr.restapi02.model;

import lombok.Data;

import java.util.List;

@Data
public class Academy {
    private int id;
    private String name;
    private String loc;
    private List<Student> studentList;
}
