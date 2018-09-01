import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class JwtInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthenticationService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.isUserLoggedIn()) {
      const loggedUser = JSON.parse(localStorage.getItem('loggedInUser'));

      req = req.clone({
        setHeaders: {
          Authorization: 'Bearer ${loggedUser.token}'
        }
      });

      return next.handle(req);
    }
  }
}
