import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup
  ages: {}[];

  constructor(public navigation: NavbarService, public formBuilder: FormBuilder) { 
    this.ages = Array.from(Array(100), (x, i) => i + 1);
  }

  ngOnInit() {
    this.navigation.hide();

    this.signUpForm = this.formBuilder.group({
      'firstName': [null, [
        Validators.required
      ]],
      'lastName': [null, [
        Validators.required
      ]],
      'email': [null, [
        Validators.required,
        Validators.email
      ]],
      'phone': [null, [
        Validators.required,
        Validators.pattern('\+3598[789]\d{7}'),
        Validators.pattern('08[789]\d{7}')
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
    alert("Signed up");
  }

}
