import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ServerAPIService } from '../services/server-api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private client: HttpClient, private serverAPI: ServerAPIService) { }

  loginUser(username: String, password: String) {
    return this.client.post(this.serverAPI.getAPIUrl().concat('/login'), { username, password }, { observe: 'response' }).pipe(
      map(response => {
        if (response && response.headers.has('Authorization')) {
          localStorage.setItem('loggedInUser', JSON.stringify(response));
        }

        return response;
      })
    );
  }

  logoutUser() {
    localStorage.removeItem('loggedInUser');
  }

  isUserLoggedIn(): boolean {
    return localStorage.getItem('loggedInUser') ? true : false;
  }
}
