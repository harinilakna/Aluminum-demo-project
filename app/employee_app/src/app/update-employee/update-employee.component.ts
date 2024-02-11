import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router,Route } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';



@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  
  id:string;
  employee: Employee = new Employee();
 
  constructor(private employeeService: EmployeeService,private router:ActivatedRoute, private route:Router ){}

   ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.getEmployee(this.id);
  
  }

  getEmployee(id:string) {
      this.employeeService.getById(id).subscribe(data =>{
      this.employee = data;
      console.log(data);
    }, error =>console.log(error))
  }
  
  updateEmployee(){
    this.employeeService.updateUserById(this.id,this.employee).subscribe(data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error =>console.log('error'));
}


goToEmployeeList(){
  this.route.navigate(['/employees'])
}
 
onSubmit(){
  this.updateEmployee();  
  //console.log (this.employee);
  }
   
 
}
