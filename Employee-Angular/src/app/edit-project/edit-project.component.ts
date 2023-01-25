import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { ProjectServiceService } from '../project-service.service';

@Component({
  selector: 'app-edit-project', 
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  project!:Project;
  id!:number;
  
  constructor(private route:ActivatedRoute,private router:Router,private projectService:ProjectServiceService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.projectService.getProjectById(this.id).subscribe({
      next:(data)=>this.project=data,
      error:(e)=>console.log(e),
      
    })

  }
  onSubmit(){
    this.projectService.updateProject(this.id,this.project).subscribe({
      next:(data)=>console.log(data),
      error:(e)=>console.log(e),
      complete:()=> this.router.navigate(['project'])
    });
  }
}
