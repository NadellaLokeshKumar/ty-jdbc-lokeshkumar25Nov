import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-see-req',
  templateUrl: './user-see-req.component.html',
  styleUrls: ['./user-see-req.component.css']
})
export class UserSeeReqComponent implements OnInit {
flat: any;
  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
  }
seereq(form: NgForm) {
this.auth.seereq(form.value).subscribe( res => {
  console.log(res);
  this.flat = res.flat;
});
}
}
