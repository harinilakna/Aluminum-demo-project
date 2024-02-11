import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';



@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  form: FormGroup;
  
constructor(private employeeService: EmployeeService,private router:Router,private fb: FormBuilder){}

  ngOnInit(): void{

    this.form = this.fb.group({
    firstName : [this.employee.firstName, [Validators.required,Validators.minLength(4)]],
    lastName : [this.employee.lastName, [Validators.required]],
    age : [this.employee.age, [Validators.required]],
    });

 
   }
  

  saveEmployee(){
    this.employeeService.addemployee(this.employee).subscribe(data =>{
      //console.log(data);
      this.goToEmployeeList();
    },
    error =>console.log('error'));
}


goToEmployeeList(){
  this.router.navigate(['/employees'])
}

get name(){
return this.form.get('firstName')
 }

onSubmit(){
//console.log (this.employee);
this.saveEmployee(); 
  }
}
