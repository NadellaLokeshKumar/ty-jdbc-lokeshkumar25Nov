import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-flat-list',
  templateUrl: './flat-list.component.html',
  styleUrls: ['./flat-list.component.css']
})
export class FlatListComponent implements OnInit {
role: any;
userDetails: any;
  constructor(private auth: AuthServiceService) {
    this.userDetails = JSON.parse(localStorage.getItem(`userDetails`));
    this.role = this.userDetails.candidate.role;
}
  list: any;
  ngOnInit() {
    this.auth.appartList().subscribe( res => {
      console.log(res);
      this.list = res.appartments;
    }, err => {
      console.log(err);
    });
  }
  bookhere(flat) {
    this.auth.bookFlat(flat).subscribe( res => {
      console.log(res);
    });
  }
}
