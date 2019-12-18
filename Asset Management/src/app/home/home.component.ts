import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  
   isAdmin(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.candidate.role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isUser(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.candidate.role === 'user') {
      return true;
    } else {
      return false;
    }
  }

isManager(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.candidate.role === 'manager') {
      return true;
    } else {
      return false;
    }
  }
  logout() {
   localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/login');
  }
   ngOnInit() {
  }

}
