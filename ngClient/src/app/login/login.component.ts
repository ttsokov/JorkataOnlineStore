import { Component, OnInit } from '@angular/core';

import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(public navigation: NavbarService) { }

  ngOnInit() {
    this.navigation.hide();
  }

}
