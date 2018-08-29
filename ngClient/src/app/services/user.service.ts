import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServerAPIService } from './server-api.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private requestHeaders: HttpHeaders;

  constructor(private http: HttpClient,
              private apiService: ServerAPIService,
              private router: Router) {

      this.requestHeaders = new HttpHeaders({
        'Content-Type': 'application/json'
      });
  }

  getAllUsers() {
    return this.http.get(this.apiService.getAPIUrl().concat('/users'),
                         {
                           headers: this.requestHeaders
                         }).subscribe(response => {
                            console.log(JSON.stringify(response));
                         });
  }
}
