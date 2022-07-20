package com.cognizant.microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microservice.Entity.Student;
import com.cognizant.microservice.Repository.StudentRepository;

@Service
public class Studentservice {
      @Autowired
	private StudentRepository SR;
      public Student save(Student student)
      {
    	 return SR.save(student);
      }
      public List<Student> listofstudents()
      {
    	 List<Student> s= SR.findAll();
		return s;
    	  
      }
      /*Ok, let's check the save() implementation at SimpleJpaRepository<T, ID>,

@Transactional
public <S extends T> S save(S entity) {

    if (entityInformation.isNew(entity)) {
        em.persist(entity);
        return entity;
    } else {
        return em.merge(entity);
    }
}
As you can see, it will check whether the ID is existed or not firstly, if the entity is already there, only update will happen by merge(entity) method and if else, a new record is inserted by persist(entity) method.*/
      public  Student updatestudent(Student student,Integer roll_no)
      {
    	  Student s=SR.findById( roll_no).get();
    	  SR.delete(s);
    	return  SR.save(student);
      }
      public String deletestudent(Integer id)
      {
    	  SR.deleteById(id);
    	  return "student data deleted";
      }
      
  	public Student fetchStudentById(Integer roll_no) {

  		return SR.findById(roll_no).get();
  	}
}
