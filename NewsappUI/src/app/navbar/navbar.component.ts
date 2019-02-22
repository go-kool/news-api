import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
isLogin:boolean;
  constructor(public service:AuthService, private router: Router) { }

  ngOnInit() {
    console.log(this.service.isLoggedIn);
    this.isLogin=this.service.isLoggedIn;
  }

  logout()
  {
    this.service.logout();
    this.router.navigate(['/login']);
  }
}
