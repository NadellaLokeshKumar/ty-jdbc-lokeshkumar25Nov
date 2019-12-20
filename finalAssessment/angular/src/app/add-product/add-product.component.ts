import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceProductService } from '../service-product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  error: any;
  constructor(private auth: ServiceProductService) { }
  ngOnInit() {
  }
  submitData(form: NgForm) {
    // tslint:disable-next-line: deprecation
    this.auth.addProduct(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.error = res.description;
      } else {
        form.reset();
        this.error = res.description;
      }
    });
  }
}
