import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  error: string;

  constructor(private auth: AuthServiceService, private router: Router) { }
  ngOnInit() {
  }
  submitform(form: NgForm) {
    this.error = null;
    this.auth.loginUser(form.value).subscribe(data => {
      console.log('Response of login', data);
      if (data && data.message === 'success') {
        localStorage.setItem('userDetails', JSON.stringify(data));
        this.router.navigateByUrl('/view');
      } else {
        this.error = data.message;
      }
     // form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;
    });
  }
}
