import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  constructor(private router:Router,private projectService:ProjectServiceService) { }

  ngOnInit(): void {
    this.projectService.getProjectById{(su)}
  }
  onSubmit(){

  }
}
