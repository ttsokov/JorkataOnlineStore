import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarService } from '../services/navbar.service';
import { ServerAPIService } from '../services/server-api.service';
import { User } from '../classes/user';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup;

  ages: {}[];

  minAge = 18;

  maxAge = 100;

  user: User;

  constructor(private navigation: NavbarService, private formBuilder: FormBuilder,
              private router: Router,
              private userService: UserService) {
    this.ages = Array.from(Array((this.maxAge - this.minAge) + 1), (v, index) => this.minAge++);

    this.user = new User('',
      '',
      '',
      '',
      '',
      0,
      '');
  }

  ngOnInit() {
    this.navigation.hide();

    this.signUpForm = this.formBuilder.group({
      'firstName': [null, [
        Validators.required,
        Validators.pattern('^([A-Z]+|[a-z]+)[a-z0-9_-]+$')
      ]],
      'lastName': [null, [
        Validators.required,
        Validators.pattern('^([A-Z]+|[a-z]+)[a-z0-9_-]+$')
      ]],
      'username': [null, [
        Validators.required,
        Validators.pattern('[A-Z]?[a-z0-9_-]+')
      ]],
      'email': [null, [
        Validators.required,
        Validators.email
      ]],
      'phone': [null, [
        Validators.required,
        Validators.pattern('^(\\+3598[789]\\d{7})|(08[789]\\d{7})$')
      ]],
      'age': [null, [
        Validators.required
      ]],
      'password': [null, [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(24)
      ]]
    });
  }

  bind() {
    this.user.firstName = this.signUpForm.get('firstName').value;
    this.user.lastName = this.signUpForm.get('lastName').value;
    this.user.username = this.signUpForm.get('username').value;
    this.user.email = this.signUpForm.get('email').value;
    this.user.phone = this.signUpForm.get('phone').value;
    this.user.age = this.signUpForm.get('age').value;
    this.user.password = this.signUpForm.get('password').value;
  }

  onSignUpSubmit() {

    this.bind();

    this.userService.signUpUser(this.user).subscribe();

    this.router.navigateByUrl('/login');
  }

}
