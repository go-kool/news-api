import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let token = this.authService.getToken();
        const re = 'https://newsapi.org/v2/everything';
        if (request.url.search(re) === -1) {
            console.log('adding header token');
        if (this.authService.isLoggedIn) {
            return next.handle(
                request.clone({
                    headers: request.headers.append('authorization', `StackRoute ${token}`)
                })
            );
        }
    }
        return next.handle(request);
    }
}
