import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee=new Employee();
  constructor(private employeeService:EmployeeService,private router:Router) { }

  // saveEmployee(){
  //   this.employeeService.createEmployee(this.employee).subscribe((data)=>{
  //     console.log(data);
  //     this.goToEmployeeList();
  //   },
  //   error=>console.log(error));
  // }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe({
      next:(data)=>console.log(data),
      error:(e)=>console.log(e),
      complete:()=>this.goToEmployeeList()    
  })
}

  goToEmployeeList(){
    this.router.navigate(['employee']);
  }
  ngOnInit():void{
  }
    onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
    }

    
  }
