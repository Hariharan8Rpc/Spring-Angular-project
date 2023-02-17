import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../model/project';
import { ProjectServiceService } from '../project-service.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
   
  projects:Project[]|undefined; 
  constructor( private projectService:ProjectServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getProjects();
  }
  private getProjects(){
    this.projectService.getProjectsList().subscribe({
      next:(data)=>this.projects=data,
      error:(e)=>console.log(e)      
    });    
  }

   projectDetail(id:number){
    this.router.navigate(['project-detail',id]);
  }
}
