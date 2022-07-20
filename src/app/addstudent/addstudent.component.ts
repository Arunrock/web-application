import { Component, OnInit } from '@angular/core';
import { student } from '../model/student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit {

  constructor(private studentservice:StudentService) { }
student:student= new student("",0,"","");
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  

createStudent():void
{
  this.studentservice.createstudent(this.student).subscribe(data=>{alert("studentcreated successfuly");});
}
}
