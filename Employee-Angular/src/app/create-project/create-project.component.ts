import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Admin from '../model/admin';
import { Project } from '../model/project';
import { ProjectServiceService } from '../project-service.service';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
project: Project=new Project();
// admin: Admin=new Admin();
  adminid: number=1;
  constructor(private projectService:ProjectServiceService, private router:Router) { }
   
  saveProject(){
    // this.project.admin.id=
    this.projectService.createProject(this.adminid,this.project).subscribe({
      next:(data)=>console.log(this.project),
      error:(e)=>console.log(e),
      complete:()=>this.goToProjectList()    
  })
  }

  goToProjectList(){
    this.router.navigate(['project']);
  }

  ngOnInit(): void {

  }
  onSubmit(){
    console.log(this.project);
    this.saveProject();
    }
}
