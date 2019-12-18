import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-remove-ass',
  templateUrl: './remove-ass.component.html',
  styleUrls: ['./remove-ass.component.css']
})
export class RemoveAssComponent implements OnInit {
  error: any;
  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
  }
  submitData(form: NgForm) {
    this.auth.removeAss(form.value).subscribe(data => {
      console.log(data);
      this.error = data.description;
      form.reset();
    }, err => {
      console.log(err);
    });
  }
}
