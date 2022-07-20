import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { student } from './model/student';
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http:HttpClient) { }
   baseurl:string="http://localhost:8083";
   //get
  getstudents():Observable<student[]>
  {
    return this.http.get<student[]>(this.baseurl+"/studentlist");
  }
  //post
  createstudent(student:student)
  {
    return this.http.post<student>(this.baseurl+"/studentdataentry",student);
  }
  //delete
  deletestudent(student:student)
  {
    return this.http.delete<student>(this.baseurl+"/deletebyid/"+student.roll_no);
  }
  //update
  updatestudent(student:student)
  {
    return this.http.put<student>(this.baseurl+"/updatestudent/"+student.roll_no,student);
  }
}
