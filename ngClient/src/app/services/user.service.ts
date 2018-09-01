import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServerAPIService } from './server-api.service';
import { Router } from '@angular/router';
import { User } from '../classes/user';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authentication/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private requestHeaders: HttpHeaders;

  constructor(private client: HttpClient,
              private serverAPI: ServerAPIService,
              private router: Router,
              private authService: AuthenticationService) {

      this.requestHeaders = new HttpHeaders({
        'Content-Type': 'application/json'
      });
  }

  signUpUser(user: User): Observable<{}> {
    return this.client.post(this.serverAPI.getAPIUrl().concat('/users'), user);
  }

  loginUser(username: String,  password: String): Observable<{}> {
    return this.authService.loginUser(username, password);
  }
}
