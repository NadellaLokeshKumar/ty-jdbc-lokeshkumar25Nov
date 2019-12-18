import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthServiceService } from '../auth-service.service';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
  }
  submitData(form: NgForm) {
  this.auth.updateAsset(form.value).subscribe( res => {
    console.log(res);
    form.reset();
  }, err => {
    console.log(err);
  });
  }
}
