import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { StudentlistComponent } from './studentlist/studentlist.component';

const routes: Routes = [
  {path:'studentlist',component:StudentlistComponent},
  {path:'addstudent',component:AddstudentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
