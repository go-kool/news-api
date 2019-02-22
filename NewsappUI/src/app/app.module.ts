import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { JwtInterceptor } from './JwtInterceptor';

import { RouterModule } from '@angular/router';
import { Authentication } from './modules/authentication/authentication.module';
import { NavbarComponent } from './navbar/navbar.component';
import { NewsApp } from './modules/newsApp/NewsApp.module';

@NgModule({
  declarations: [
    AppComponent,NavbarComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    NewsApp,
    Authentication
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
