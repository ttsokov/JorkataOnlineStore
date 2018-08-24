import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  private visible: boolean;

  constructor() { 
    this.visible = true;
  }

  isVisible() {
    return this.visible;
  }

  show() {
    this.visible = true;
  }

  hide() {
    this.visible = false;
  }
}
