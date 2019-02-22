import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { ArticlesComponent } from './modules/newsApp/component/articles/articles.component';
import { FavouriteComponent } from './modules/newsApp/component/favourite/favourite.component';
import { LoginComponent } from './modules/authentication/components/login/login.component';
import { SignupComponent } from './modules/authentication/components/signup/signup.component';


const routes: Routes = [
  {path : '',component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path : 'signup',component:SignupComponent},
  {path:'Dashboard',canActivate:[AuthGuard],component:ArticlesComponent},
  {path:'favourite',canActivate:[AuthGuard],component:FavouriteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
