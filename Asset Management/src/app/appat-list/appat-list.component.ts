import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-appat-list',
  templateUrl: './appat-list.component.html',
  styleUrls: ['./appat-list.component.css']
})
export class AppatListComponent implements OnInit {

  constructor(private auth: AuthServiceService) { }
  list: any;

  ngOnInit() {
    this.auth.appartList().subscribe( res => {
      console.log(res);
      this.list = res.appartments;
    }, err => {
      console.log(err);
    });
  }

}
