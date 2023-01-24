import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './model/employee';
import { Project } from './model/project';

@Injectable({       
  providedIn: 'root'
})
export class ProjectServiceService {
  private projectUrl="http://localhost:8080/employeeApi/project";
  private employeeurl="http://localhost:8080/employeeApi";
  constructor(private httpClient:HttpClient) { }

  createProject( id:number,project:Project):Observable<Object>{
    // project.admin.id
    return this.httpClient.post(`${this.projectUrl}/addProject/${id}`,project);
  }

  getProjectsList():Observable<Project[]>{
    return this.httpClient.get<Project[]>(`${this.projectUrl}/getproject`);
  }

  getProjectById(id:number):Observable<Project>{
    return this.httpClient.get<Project>(`${this.projectUrl}/find/${id}`);
  }

  getEmployeesInProject(id:number):Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.employeeurl}/employeeInProject/${id}`);
  }

  deleteEmployeeInProject(addrId:number,projectId:number):Observable<Object>{
    return this.httpClient.delete(`${this.projectUrl}/deleteEmployees/${addrId}/${projectId}`);
  }

  addEmployeeToProject(addrId:number,projectId:number):Observable<Object>{
    return this.httpClient.post(`${this.projectUrl}/insertEmployees/${addrId}/${projectId}`,null);
  } 

}
