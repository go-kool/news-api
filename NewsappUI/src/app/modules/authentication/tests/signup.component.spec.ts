import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from '../components/signup/signup.component';
import { AppComponent } from 'src/app/app.component';
import { LoginComponent } from '../components/login/login.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { FavouriteComponent } from '../../newsApp/component/favourite/favourite.component';
import { ArticlesComponent } from '../../newsApp/component/articles/articles.component';
import { NavbarComponent } from 'src/app/navbar/navbar.component';

describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        LoginComponent,
        SignupComponent,
        NavbarComponent,
        ArticlesComponent,
        FavouriteComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserModule,FormsModule,ReactiveFormsModule,
        HttpClientModule
      ],
      providers: []
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should be valid when field is not empty',async(()=> {
    component.signupForm.controls['name'].setValue('Testing');
    component.signupForm.controls['email'].setValue('Testing@gmail.com');
    component.signupForm.controls['password'].setValue('Testing123');
    expect(component.signupForm.valid).toBeTruthy();
  }));


  it('form should be not be valid when field is empty',async(()=> {
    component.signupForm.controls['name'].setValue('');
    component.signupForm.controls['email'].setValue('Testing');
    component.signupForm.controls['password'].setValue('');
    expect(component.signupForm.invalid).toBeTruthy();
  }));


  it('form should be not be valid when name field is empty',async(()=> {
    component.signupForm.controls['name'].setValue('');
    component.signupForm.controls['email'].setValue('Testing@test.com');
    component.signupForm.controls['password'].setValue('123456789');
    expect(component.signupForm.invalid).toBeTruthy();
  }));

  it('form should be not be valid when password field is empty',async(()=> {
    component.signupForm.controls['name'].setValue('');
    component.signupForm.controls['email'].setValue('Testing@test.com');
    component.signupForm.controls['password'].setValue('123456789');
    expect(component.signupForm.invalid).toBeTruthy();
  }));


});
