import { Component, OnInit } from '@angular/core';
import { ServiceProductService } from '../service-product.service';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {
  product: any;
  constructor(private auth: ServiceProductService) { }

  ngOnInit() {
  }
  submitData(form) {
    this.auth.searchById(form.value).subscribe(res => {
      console.log(res);
      this.product = res.product;
    });
  }
}
