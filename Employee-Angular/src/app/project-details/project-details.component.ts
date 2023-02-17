import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/employee';
import { Project } from '../model/project';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { ProjectServiceService } from '../project-service.service';
import { routerTransition } from '../router.animation';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css'],
  // animations: [routerTransition()] 
})
export class ProjectDetailsComponent implements OnInit {
  id!:number
  project!:Project;
  employees!:Employee[];
  employees1:Employee[]|undefined;
  fromDialog!:String;
  
  
  constructor(private route:ActivatedRoute,private router:Router,private projectService:ProjectServiceService,private employeeService:EmployeeService,public dialog:MatDialog) { }
  
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.project=new Project();
    this.projectService.getProjectById(this.id).subscribe({
      next:(data)=>this.project=data
    });
   this. getEmployeeInProject();
  
    
    // this.projectService.getEmployeesInProject(this.id).subscribe({
    //   next:(data)=>this.employees=data
    // })
  }

  getEmployeeInProject(){
    this.projectService.getEmployeesInProject(this.id).subscribe({
      next:(data)=>this.employees=data
    })

     console.log(this.employees)
  }

  deleteEmployeeFromProject(addrId:number,projectId:number){
    this.projectService.deleteEmployeeInProject(addrId,projectId).subscribe({
      next:(data)=>console.log(data),
        error:(e)=>console.log(e),
        complete:()=>this.ngOnInit()
    })
  }
  
  getAllEmployees(){
    this.employeeService.getEmployeesList().subscribe({
      next:(data)=>this.employees=data,
      error:(e)=>console.log(e),
     });
  }

  addEmployeestoProject(addrId:number,projectId:number){
    this.projectService.addEmployeeToProject(addrId,projectId).subscribe({
      next:(data)=>console.log(data),
        error:(e)=>console.log(e),
        // complete:()=>this.ngOnInit()
    })
  }

  openDialog(){
    this.dialog.open(PopUpComponent);
  }

  employeesProject(id:number){
    this.router.navigate(['addEmployeeToProject',id]);
  }
  updateProject(id:number){
    this.router.navigate(['updateProject',this.id]);
  }
  deleteProject(id:number){
    this.projectService.deleteProject(id).subscribe({
      next:(data)=>console.log(data),
      error:(e)=>console.log(e),
      complete:()=> this.router.navigate(['project'])
    })
  }

}
