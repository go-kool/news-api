import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../services/news.service';
import { AuthService } from 'src/app/auth.service';


@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  constructor(private service: AuthService, private news_service: NewsService) { }
  haveData:boolean=true;
  articles: any;
  message:string="";
  ngOnInit() {
    this.news_service.getAllFavouriteArticles().subscribe(
      data => {
       this.articles=data;
      });
  }
}
