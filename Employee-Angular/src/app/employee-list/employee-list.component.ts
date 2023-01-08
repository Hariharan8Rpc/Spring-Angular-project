import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees:Employee[] | undefined;
  constructor(private employeeService:EmployeeService,
    private router:Router) { }
  
  ngOnInit(): void {
  //   this.employees=[{
  //     "id":1,
  //     "firstName":"hari",
  //     "lastName":"haran",
  //     "department":"sales"
  //   },
  //   {
  //     "id":2,
  //     "firstName":"cfhari",
  //     "lastName":"haran",
  //     "department":"sales"
  //   }
  // ]
  this.getEmployees();
   
}
// private getEmployees(){
//   this.employeeService.getEmployeesList().subscribe(data => {
//     this.employees=data;
//     console.log(this.employees);
//   });
//   }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe({
     next:(data)=>this.employees=data,
     complete:() =>console.log(this.employees)
    });
    }
// call to update employee through router
     updateEmployee(id:number){
      this.router.navigate(['update-employee',id]);
    }

    deleteEmployee(id:number){
      this.employeeService.deleteEmployee(id).subscribe({
        next:(data)=>console.log(data),
        error:(e)=>console.log(e),
        complete:()=>this.getEmployees()
      })
    }

    employeeDetails(id:number){
      this.router.navigate(['employee-details',id]);
    }
}
