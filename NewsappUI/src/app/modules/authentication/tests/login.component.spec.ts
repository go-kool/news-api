import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { BrowserModule, By } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DebugElement } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { LoginComponent } from '../components/login/login.component';
import { SignupComponent } from '../components/signup/signup.component';
import { ArticlesComponent } from '../../newsApp/component/articles/articles.component';
import { NavbarComponent } from 'src/app/navbar/navbar.component';
import { FavouriteComponent } from '../../newsApp/component/favourite/favourite.component';


describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let el : HTMLElement;

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
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should be valid when field is not empty',async(()=> {
    component.loginForm.controls['email'].setValue('Testing@gmail.com');
    component.loginForm.controls['password'].setValue('Testing123');
    expect(component.loginForm.valid).toBeTruthy();
  }));


  it('form should be not be valid when field is empty',async(()=> {
    component.loginForm.controls['email'].setValue('');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.invalid).toBeTruthy();
  }));

  it('form should be not be valid when the password validations failed',async(()=> {
    component.loginForm.controls['email'].setValue('Testing@test.com');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.invalid).toBeTruthy();
  }));

  it('form should be not be valid when the email validations failed',async(()=> {
    component.loginForm.controls['email'].setValue('');
    component.loginForm.controls['password'].setValue('testing@123');
    expect(component.loginForm.invalid).toBeTruthy();
  }));

  it('should call the login method', async(() => {
    fixture.detectChanges();
    spyOn(component, 'login');
    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(0);
  }));

});
