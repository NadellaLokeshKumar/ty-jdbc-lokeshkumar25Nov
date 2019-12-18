import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-cand-list',
  templateUrl: './cand-list.component.html',
  styleUrls: ['./cand-list.component.css']
})
export class CandListComponent implements OnInit {

  constructor(private auth: AuthServiceService) { }
  list: any;
  ngOnInit() {
    this.auth.candList().subscribe( res => {
      console.log(res);
      this.list = res.candidates;
    }, err => {
      console.log(err);
    });
  }
}
