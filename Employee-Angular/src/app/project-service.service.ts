import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
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
    return this.httpClient.post(`${this.projectUrl}/addProject/${id}`,project).pipe(
      catchError(this.handleError)
    );
  }

  getProjectsList():Observable<Project[]>{
    return this.httpClient.get<Project[]>(`${this.projectUrl}/getproject`).pipe(
      catchError(this.handleError)
    );
  }

  getProjectById(id:number):Observable<Project>{
    return this.httpClient.get<Project>(`${this.projectUrl}/find/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  getEmployeesInProject(id:number):Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.employeeurl}/employeeInProject/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  getEmployeesNotInProject(id:number):Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.employeeurl}/employeeNotInProject/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  deleteEmployeeInProject(addrId:number,projectId:number):Observable<Object>{
    return this.httpClient.delete(`${this.projectUrl}/deleteEmployees/${addrId}/${projectId}`).pipe(
      catchError(this.handleError)
    );
  }
  deleteProject(projectId:number):Observable<Object>{
    return this.httpClient.delete(`${this.projectUrl}/delete/${projectId}`).pipe(
      catchError(this.handleError)
    );
  }

  addEmployeeToProject(addrId:number,projectId:number):Observable<Object>{
    return this.httpClient.post(`${this.projectUrl}/insertEmployees/${addrId}/${projectId}`,null).pipe(
      catchError(this.handleError)
    );
  }

  updateProject(projectid:number,project:Project):Observable<Object>{
    console.log('inservice',project);
    return this.httpClient.put(`${this.projectUrl}/update/${projectid}`,project).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
