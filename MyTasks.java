package com.example.tasktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class MyTasks {
    private String ID;
    private String title;
    private String desc;
    private String status;

}
