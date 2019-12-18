import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {

  error: String;
  constructor(private auth: AuthServiceService, private router: Router) { }

  ngOnInit() {
  }
  submitData(form: NgForm) {
    this.error = null;
    this.auth.registerUser(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
      this.router.navigateByUrl('/login');
      } else {
      form.reset();
      this.error = res.message;
      }
    }, err => {
      console.log(err);
    
    });
  }
  ngOnDestroy() {
    this.error = null;
  }
}
