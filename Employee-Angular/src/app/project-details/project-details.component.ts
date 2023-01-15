import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/employee';
import { Project } from '../model/project';
import { ProjectServiceService } from '../project-service.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {
  id!:number
  project!:Project;
  employees:Employee[]|undefined;
  constructor(private route:ActivatedRoute,private projectService:ProjectServiceService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.project=new Project();
    this.projectService.getProjectById(this.id).subscribe({
      next:(data)=>this.project=data
    });

    this.projectService.getEmployeesInProject(this.id).subscribe({
      next:(data)=>this.employees=data
    })
  }

  deleteEmployeeFromProject(id:number){
    
  }

   


}
