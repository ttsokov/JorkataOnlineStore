import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarService } from '../services/navbar.service';

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

  constructor(public navigation: NavbarService, public formBuilder: FormBuilder) {
    this.ages = Array.from(Array((this.maxAge - this.minAge) + 1), (v, index) => this.minAge++);
  }

  ngOnInit() {
    this.navigation.hide();

    this.signUpForm = this.formBuilder.group({
      'firstName': [null, [
        Validators.required,
        Validators.pattern('[A-Z]?[a-z0-9_-]+')
      ]],
      'lastName': [null, [
        Validators.required,
        Validators.pattern('[A-Z]?[a-z0-9_-]+')
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
      'age': [null],
      'password': [null, [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(24)
      ]]
    });
  }

  onSignUpSubmit() {
    alert('Signed up');
  }

}
