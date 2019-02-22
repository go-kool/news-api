import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { AuthenticationService } from '../../services/authentication.service';


@Component({  
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private authenticationService: AuthenticationService,private service:AuthService) { }

  loginForm = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', [Validators.required,Validators.maxLength(30)]]
  });

  message:string="";

  ngOnInit() {
  }

  login() {
    this.authenticationService.login(this.loginForm.value).subscribe(data => {
      if (data!= null) {
        console.log(data.body.token);
        this.service.token = data.body.token;
        this.service.login();
        this.router.navigate(['Dashboard']);
      }
    }, error => {
      if (error.status == 401) {
        this.message = "Invalid Email or Password!";
      }
    });
  }
}
