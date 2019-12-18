import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-remove-can',
  templateUrl: './remove-can.component.html',
  styleUrls: ['./remove-can.component.css']
})
export class RemoveCanComponent implements OnInit {
  error: any;
  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
  }
  submitData(form: NgForm) {
    this.auth.removeUser(form.value).subscribe(data => {
      console.log(data);
      this.error = data.description;
      form.reset();
    }, err => {
      console.log(err);
    });
  }
}
