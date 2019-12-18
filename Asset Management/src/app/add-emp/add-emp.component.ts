import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {

  constructor(private auth: AuthServiceService) { }
    error: any;
  ngOnInit() {
  }
  submitData(form: NgForm) {
    this.error = null;
    this.auth.registerUser(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.error = res.message;
         } else {
      this.error = res.message;
      }
    });
  }
}
