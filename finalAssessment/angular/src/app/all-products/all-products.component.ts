import { Component, OnInit } from '@angular/core';
import { ServiceProductService } from '../service-product.service';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {
  products: any;
  constructor(private auth: ServiceProductService) { }

  ngOnInit() {
    this.auth.allProducts().subscribe(res => {
      console.log(res);
      this.products = res.product;
    }, err => {
      console.log(err);
    });
  }

}
