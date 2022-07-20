package com.cognizant.microservice.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.cognizant.microservice.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
