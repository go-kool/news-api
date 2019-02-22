import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ArticlesComponent } from './component/articles/articles.component';
import { FavouriteComponent } from './component/favourite/favourite.component';
import { NewsService } from './services/news.service';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [ArticlesComponent,FavouriteComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports: [ArticlesComponent,FavouriteComponent],
  providers:[NewsService]
})
export class NewsApp { }
