import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable}from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private url="http://localhost:8080/employeeApi";
  constructor(private httpClient:HttpClient) { }

    getEmployeesList():Observable<Employee[]>{
      return this.httpClient.get<Employee[]>(`${this.url}`);
    }

    createEmployee(employee:Employee):Observable<Object>{
      return this.httpClient.post(`${this.url}`,employee);
    }
}



