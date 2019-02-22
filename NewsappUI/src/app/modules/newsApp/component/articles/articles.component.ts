import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth.service';
import { NewsService } from '../../services/news.service';


@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  articles: any = [];
message:string="";
 
  constructor(private router: Router,private service:AuthService, private news_service: NewsService,private formBuilder: FormBuilder) { }
  searchForm = this.formBuilder.group({
    search: ['', Validators.required],
  });

  ngOnInit() {
    this.news_service.getAllArticles().subscribe(
      data => {
        this.articles=data["articles"];
        console.log(this.articles);
      });
  }
  
  search()
  {
    this.news_service.search(this.searchForm.value.search).subscribe(
      data => {
        this.articles=[];
        this.articles=data["articles"];
    });
    this.searchForm.reset();
  }

  markFavourite(article)
  {
    console.log(this.service.token);
    this.news_service.favourite(article).subscribe(
      data =>{
        
      }, error => {
        if (error.status == 401) {
          this.message= error['error']['message'];
        }
  })
}
}