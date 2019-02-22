import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  message: string = "";

  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService, private router: Router) { }

  signupForm = this.formBuilder.group({
    name: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', [Validators.required, Validators.maxLength(30), Validators.minLength(6)]],
  });

  ngOnInit() {
  }

  signup() {
    console.log(this.signupForm.value);
    this.authenticationService.signup(this.signupForm.value).subscribe(data => {
      if (data.message == "User registered successfully") {
        this.router.navigate(['login']);
        this.message = "Signup Sucessfull"
      }
    }, error => {
        this.message= error['error']['message'];
    });
  }
}
