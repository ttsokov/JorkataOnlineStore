import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarService } from '../services/navbar.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import {throwError} from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private navigation: NavbarService, private formBuilder: FormBuilder,
              private userService: UserService, private router: Router) { }

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
    this.userService.loginUser(this.loginForm.get('username').value, this.loginForm.get('password').value).subscribe(
      response => {
        this.router.navigateByUrl('/home');
      }, error => {
        return throwError(error);
      }
    );
  }

}
