package com.example.lab5_q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor

public class Event {


    private String ID ;
    private String description ;
    private int capacity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private int startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate endTime ;


}
