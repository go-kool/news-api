import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn=false;
  token:any;
  userId:string;
  constructor() { }

  login(){
    this.isLoggedIn=true;
  }
  logout() {
    this.isLoggedIn=false;
  }
  setToken(token: string) {
    this.token = token;
  }
  getToken(): string {
    return this.token;
  }
}
