import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable,throwError}from 'rxjs';
import{catchError}from 'rxjs/operators';
import { Employee } from './model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private url="http://localhost:8080/employeeApi";
  
  constructor(private httpClient:HttpClient) { }

    getEmployeesList():Observable<Employee[]>{
      return this.httpClient.get<Employee[]>(`${this.url}`).pipe(
        catchError(this.handleError)
      );
    }
    // getEmployeesList():Observable<any>{
    //   return this.httpClient.get<any>(`${this.url}`)
    //   .pipe(catchError(this.handleError))
    // }
    //  handleError(error){
    //   return throwError(error.message || "Server error ")
    //  }

    createEmployee(employee:Employee):Observable<Object>{
      return this.httpClient.post(`${this.url}`,employee).pipe(
        catchError(this.handleError)
      );
    }
    
    getEmployeeById(id:number):Observable<Employee>{
      return this.httpClient.get<Employee>(`${this.url}/find/${id}`).pipe(
        catchError(this.handleError)
      );
    }
    updateEmployee(id:number,employee:Employee):Observable<Object>{
      console.log('inservice',employee);
      return this.httpClient.put(`${this.url}/update/${id}`,employee).pipe(
        catchError(this.handleError)
      );
    }

    deleteEmployee(id:number):Observable<Object>{
      return this.httpClient.delete(`${this.url}/delete/${id}`).pipe(
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
          return throwError(() => new Error(error.error));
      }
      // Return an observable with a user-facing error message.
      return throwError(() => new Error('Something bad happened; please try again later.'));
    }
}



