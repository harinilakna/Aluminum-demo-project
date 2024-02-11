import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable} from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  private baseURL = 'http://localhost:8080/api/user/view';

  private postURL = 'http://localhost:8080/api/user/insert';

  private updateURL = 'http://localhost:8080/api/user/update/';

  private getByURL ='http://localhost:8080/api/user/getById/';
 
  private deleteURL = 'http://localhost:8080/api/user/delete/';

  constructor(private httpclient:HttpClient) { }

  getAllUser(): Observable<Employee[]>{
    return this.httpclient.get<Employee[]>(this.baseURL);
  }

  addemployee(employee:Employee):Observable<object>{
    return this.httpclient.post(this.postURL,employee);
  }

  getById(id:string):Observable<Employee>{
   return this.httpclient.get<Employee>(this.getByURL+id);
   }

  updateUserById(id:string,employee:Employee):Observable<object>{
   return this.httpclient.put<object>(this.updateURL+id,employee);
    }

  deleteUserById(id:string):Observable<object>{
      return this.httpclient.delete(this.deleteURL+id);
       }
  
}
