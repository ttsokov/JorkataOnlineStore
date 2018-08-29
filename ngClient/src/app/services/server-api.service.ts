import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServerAPIService {

  private APIUrl: String;

  constructor() {
    this.APIUrl = "http://localhost:8080"
  }

  getAPIUrl() {
    return this.APIUrl;
  }

  setAPIUrl(newAPIURL: String) {
      this.APIUrl = newAPIURL;
  }
}
