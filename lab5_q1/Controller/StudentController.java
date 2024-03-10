package com.example.lab5_q1.Controller;


import com.example.lab5_q1.API.ApiResponse;
import com.example.lab5_q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Student> getStudent(){
        return students;
    }


    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("Student added");
    }



    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index , @RequestBody Student student){

        students.set(index , student);
        return new ApiResponse("updated");
    }

    @DeleteMapping("/delete/{delete}")
    public ApiResponse deleteStudent(@PathVariable int delete){
        students.remove(delete);
        return new ApiResponse("deleted");
    }



    @GetMapping("/names/{index}")
    public String getNames(@PathVariable int index){
        return students.get(index).getName();

    }


    @GetMapping("/age/{index}")
    public int getAges(@PathVariable int index){
        return students.get(index).getAge();
    }


    @GetMapping("/college/{index}")
    public String degree(@PathVariable int index){
        return students.get(index).getDegree();
    }


    @GetMapping("/status/{index}")
    public boolean getStatus(@PathVariable int index){
        return students.get(index).isStatus();
    }










}
