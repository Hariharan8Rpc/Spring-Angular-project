import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from './model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {
  private projectUrl="http://localhost:8080/employeeApi/project";
  
  constructor(private httpClient:HttpClient) { }
  getProjectsList():Observable<Project[]>{
    return this.httpClient.get<Project[]>(`${this.projectUrl}/getproject`);
  }

  getProjectById(id:number):Observable<Project>{
    return this.httpClient.get<Project>(`${this.projectUrl}/find/${id}`);
  }
}
