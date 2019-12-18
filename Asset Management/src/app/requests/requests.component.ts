import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { isRejected } from 'q';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
flats: any;
  constructor(private auth: AuthServiceService) { }

  ngOnInit() {
this.auth.request().subscribe( res => {
  console.log(res);
  this.flats = res.flats;
});
  }
approved(f) {
this.auth.approve(f).subscribe( res => {
  console.log(res);
});
}
rejected(f) {
this.auth.reject(f).subscribe(res => {
  console.log(res);
});
}
}


