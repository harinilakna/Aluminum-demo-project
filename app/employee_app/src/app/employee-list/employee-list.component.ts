import {Component, OnInit} from '@angular/core';
import { Route, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  employee:Employee = new Employee();

  constructor(private employeeService: EmployeeService,private router:Router){}
  
  ngOnInit():void{
    this.getEmployees();
   
 }
  getEmployees() {
    this.employeeService.getAllUser().subscribe(data =>{
      this.employees = data;
    })
  }

  getEmployee(id:string) {
    this.employeeService.getById(id).subscribe(data =>{
      this.employee = data;
    })
  }

  updateEmployee(id:string){
    this.getEmployee(id);
    //console.log(id);
    this.router.navigate(['update-employee',id])

  }

  deleteEmployee(id:string){
   this.employeeService.deleteUserById(id).subscribe(data =>{
    console.log(data);
    this.getEmployees();
    })

}


}