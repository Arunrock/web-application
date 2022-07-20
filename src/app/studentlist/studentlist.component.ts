import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { student } from '../model/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrls: ['./studentlist.component.css']
})
export class StudentlistComponent implements OnInit {
  empDetail !: FormGroup;
  constructor(private studentservice:StudentService) { }
students:student[]=[];
  ngOnInit(): void {
    this.studentservice.getstudents() .subscribe((data: student[])=>{ console.log(data); 
      this.students= data;
  })
}
  deleteStudent(student:student):void
  {
    console.log("student to be delete",student.roll_no+"-"+student.name) 
    this.studentservice.deletestudent(student).subscribe(data =>{
    
    this.students =this.students.filter(u=> u!==  student);
  })
  }
 
  updateStudent(student:student)
  {
   //this.studentservice.updatestudent().subscribe(data=>{
    
  // })
  }
}
