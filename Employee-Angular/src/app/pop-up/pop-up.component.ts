import { Component, Inject, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/employee';
import { ProjectServiceService } from '../project-service.service';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {
  id!:number;
 
  fromDialog!:String;
  employees1:Employee[]|undefined;
  mylist=['keyboard','derrvrwftd3','vrcdar4df34',1321]
  constructor(private route:ActivatedRoute,private router:Router,private projectService:ProjectServiceService,private employeeService:EmployeeService,public dialog:MatDialog) { }
  // @Inject(MAT_DIALOG_DATA) public data1
  
  getAllEmployees(){
    this.employeeService.getEmployeesList().subscribe({
      next:(data)=>this.employees1=data,
      error:(e)=>console.log(e),
     });
  }

  addEmployeestoProject(addrId:number){
    this.projectService.addEmployeeToProject(addrId,this.id).subscribe({
      next:(data)=>console.log(data),
        error:(e)=>console.log(e),
        complete:()=> this.router.navigate(['project-detail',this.id])
    })
  }

  ngOnInit(): void {
    this.getAllEmployees();
    this.id=this.route.snapshot.params['id'];
  }
  // @ViewChild('dialogRef')
  // dialogRef!: TemplateRef<any>
  // openTempDialog(){
  // //   this.employeeService.getEmployeesList().subscribe({
  // //     next:(data)=>this.employees1=data,
  // //     error:(e)=>console.log(e),
  // //    });

  //    this.dialog.open(this.dialogRef,{data:this.mylist,
  //     panelClass:'fullscreen-dialog',height:'100vw',width:'100%'})
  
  //    }
}
