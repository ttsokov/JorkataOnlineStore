import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(public navigation: NavbarService, public formBuilder: FormBuilder) { }

  ngOnInit() {
    this.navigation.hide();

    this.loginForm = this.formBuilder.group({
      'username': [null, [
        Validators.required,
        Validators.pattern('[A-Z]?[a-z0-9_-]+')
      ]],
      'password': [null, [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(24)
      ]]
    });
  }

  onLoginSubmit() {
    alert('Logged in');
  }

}
