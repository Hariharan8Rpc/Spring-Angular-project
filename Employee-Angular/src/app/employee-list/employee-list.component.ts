import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit ,OnDestroy{
   
  employees:Employee[]|undefined; 
  currentEmployeeList!: Employee;
  errorMessage!: string;
  // currentIndex = -1;
  // title = '';

  // page = 1;
  // count = 0;
  // pageSize = 3;
  // pageSizes = [3, 6, 9];
  constructor(private employeeService:EmployeeService,
  private router:Router) { }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
     error!:String

  ngOnInit(): void {

  this.getEmployees();
}

  // private getEmployees(){
  //   this.employeeService.getEmployeesList().subscribe({
  //    next:(data)=>this.employees=data,
  //    error:(e)=>console.log(e),
  //   //  complete:()=>this.router.navigate(['employee'])
  //   });
  //   }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe((data)=>{
    this.employees=data;
    },(err)=>{
      this.errorMessage=err.message;
    });
  }

// call to update employee through router
     updateEmployee(id:number){
      this.router.navigate(['update-employee',id]);
    }

    deleteEmployee(id:number){
      // this.employeeService.deleteEmployee(id).subscribe({
      //   next:(data)=>console.log(data),
      //   // error:(e)=>console.log(e),
      //   complete:()=>this.getEmployees()
      // },(err)=>{
      //   this.errorMessage=err.message;
      // });
      this.employeeService.deleteEmployee(id).subscribe(()=>{
      this.getEmployees()
      },(err)=>{
        this.errorMessage=err.message;
      });
      
    }

    employeeDetails(id:number){
      this.router.navigate(['employee-details',id]);
    }
}
