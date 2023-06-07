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
  employees1: Employee[] = []
  employees2:Employee[]=[];
  employees3:Employee[]=[];
  constructor(private route:ActivatedRoute,private router:Router,private projectService:ProjectServiceService,private employeeService:EmployeeService,public dialog:MatDialog) {}
  
  getEmployeesNotInProject(){
    this.id=this.route.snapshot.params['id']
    this.projectService.getEmployeesNotInProject(this.id).subscribe({
      next:(data)=>this.employees1=data,
      error:(e)=>console.log(e),
      complete:()=> console.log(this.employees1)
     });

    //  this.projectService.getEmployeesInProject(this.id).subscribe({
    //   next:(data)=>this.employees2=data,
    //   error:(e)=>console.log(e),
    //   complete:()=> console.log(this.employees2)
    //  });
     
    //  this.employees3=this.employees1.concat(this.employees2)
    // console.log("before",this.employees3)
    //  this.employees1.forEach(element1 => {
    //   this.employees2.forEach(element2=>{
    //         if(element1.id!=element2.id){
    //           console.log(element1.id);
    //           this.employees3.push(element1);
    //         }
    //   });
    //  });
      // this.employees3=this.employees1?.filter((i,p)=>this.employees2?.indexOf(i)===p);
  // this.removeDup(this.employees1,this.employees2)
    }
 
    // removeDup(a:Employee[],b:Employee[]){
    //   console.log("rhfbj",a,b)
    //   function compareEmployee(a:Employee,b:Employee){
    //     return a.id===b.id
    //   }
    //   this.employees3=a.filter(x=>!b.some(y=>compareEmployee(x,y)))
    //   console.log("reult",this.employees3);
    //   return this.employees3;
    // }
// ---
  addEmployeestoProject(addrId:number){
    this.projectService.addEmployeeToProject(addrId,this.id).subscribe({
      next:(data)=>console.log(data),
        error:(e)=>console.log(e),
        complete:()=> this.router.navigate(['project-detail',this.id])
    })
  }

  ngOnInit(): void {
    this.getEmployeesNotInProject();
    this.id=this.route.snapshot.params['id'];
  }
  // @ViewChild('dialogRef')
  // dialogRef!: TemplateRef<any>
  // openTempDialog(){
  // //   this.employeeService.getEmployeesList().subscribe({
  // //     next:(data)=>this.employees1=data,
  // //     error:(e)=>console.log(e),
  // //   
 });

  //    this.dialog.open(this.dialogRef,{data:this.mylist,
  //     panelClass:'fullscreen-dialog',height:'100vw',width:'100%'})
  
  //    }
}
