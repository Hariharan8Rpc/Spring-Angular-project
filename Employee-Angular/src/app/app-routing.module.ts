import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { EditProjectComponent } from './edit-project/edit-project.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PopUpComponent } from './pop-up/pop-up.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path:'employee',component:EmployeeListComponent},
  {path:'create-employee',component:CreateEmployeeComponent},
  {path:'home',component:HomepageComponent},
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'update-employee/:id',component:UpdateEmployeeComponent},
  {path:'employee-details/:id',component:EmployeeDetailsComponent},
  {path:'project',component:ProjectListComponent},
  {path:'project-detail/:id',component:ProjectDetailsComponent},
  {path:'createProject',component:CreateProjectComponent},
  {path:'addEmployeeToProject/:id',component:PopUpComponent},
  {path:'updateProject/:id',component:EditProjectComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
