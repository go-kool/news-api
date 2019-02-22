import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {

  loginUrl:string="http://localhost:8082/api/v1/userservice/login";
  signupUrl:string="http://localhost:8082/api/v1/userservice/register";

  constructor(private http:HttpClient) { }

  login(loginform): Observable<any> 
  {
    return this.http.post<any>(this.loginUrl,loginform,{observe: 'response'})
  }

  signup(signupform): Observable<any> 
  {
    return this.http.post<any>(this.signupUrl,signupform,httpOptions)
  }
}
