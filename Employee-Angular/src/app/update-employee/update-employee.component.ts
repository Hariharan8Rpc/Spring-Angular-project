import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  id!: number;
  employee:Employee=new Employee();
  em:Employee=new Employee();
  constructor( private employeeService:EmployeeService,
  private route:ActivatedRoute,
  private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe({     
      next:(data)=>this.employee=data,
      error:(e)=>console.log(e)    
    });
  }
  onSubmit(){
    this.em=this.employee;
    console.log('addressvalue is',this.employee.address);
    this.em.address=this.employee.address;
    this.employeeService.updateEmployee(this.id,this.em).subscribe({
      next:(data)=>console.log(data),
      error:(e)=>console.log(e),
      complete:()=>this.goToEmployeeList()    
    });
  }

  goToEmployeeList(){
    this.router.navigate(['employee']);
  }

}
