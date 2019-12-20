import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceProductService } from '../service-product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  error: any;
  constructor(private auth: ServiceProductService) { }

  ngOnInit() {
  }
  submitData(form: NgForm) {
    // tslint:disable-next-line: deprecation
    this.auth.updateProduct(form.value).subscribe(res => {
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
