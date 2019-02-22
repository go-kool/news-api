import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class NewsService {
  saveArticleUrl:string="http://localhost:8083/api/v1/news";
  getAllFavouriteArticlesUrl:string="http://localhost:8083/api/v1/news/getArticles"
  api_key:string='cc190edd640a47b3a861a41171404af4';

  constructor(private http:HttpClient) { }



  getAllArticles(): Observable<any> 
  {
    return this.http.get('https://newsapi.org/v2/everything?q="a"&language=en&apiKey='+this.api_key);
  }

  search(searchText): Observable<any> 
  {
    return this.http.get('https://newsapi.org/v2/everything?q='+searchText+'&language=en&apiKey='+this.api_key);
  }

  favourite(article)
  {
    let jsonArticle = JSON.stringify({
      title:article.title,
      description:article.description,
      url:article.url,
      urlToImage:article.urlToImage,
       });
       console.log(jsonArticle);
    return this.http.post(this.saveArticleUrl,jsonArticle,httpOptions );
  }

  getAllFavouriteArticles():Observable<any>
  {
    return this.http.get<any>(this.getAllFavouriteArticlesUrl,httpOptions);
  }
}
