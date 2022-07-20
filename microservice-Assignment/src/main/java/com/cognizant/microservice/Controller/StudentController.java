package com.cognizant.microservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservice.Entity.Student;
import com.cognizant.microservice.Service.Studentservice;



@RestController
@CrossOrigin(origins = "*")
public class StudentController {
	@Autowired
private 	Studentservice ss;
@GetMapping("/studentlist")

public List<Student >studentlist()
{
	List<Student> s=  ss.listofstudents();
	return s;
}
@PostMapping(value="/studentdataentry", consumes = MediaType.APPLICATION_JSON_VALUE)
public Student insert(@RequestBody Student student)
{
	return  ss.save(student);
}
@GetMapping("/fetchbyid{roll_no}")
public Student fetch(@RequestParam 	Integer roll_no)
{
	return ss.fetchStudentById(roll_no);
}
@DeleteMapping("/deletebyid/{roll_no}")
public String delete(@PathVariable("roll_no") Integer roll_no)
{
	return ss.deletestudent(roll_no);
}
@PutMapping("/updatestudent/{roll_no}")
public Student update(@PathVariable("roll_no") Integer roll_no,@RequestBody Student student )
{
	return ss.updatestudent(student,roll_no);
}
}
