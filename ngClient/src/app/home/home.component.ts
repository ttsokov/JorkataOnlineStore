import { Component, OnInit } from '@angular/core';

import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public navbar: NavbarService) { }

  ngOnInit() {
    this.navbar.show();
  }

}
