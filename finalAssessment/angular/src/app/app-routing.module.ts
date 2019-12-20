import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { SearchProductComponent } from './search-product/search-product.component';


const routes: Routes = [
  {path: `addproduct`, component: AddProductComponent},
  {path: `updateproduct`, component: UpdateProductComponent},
  {path: `getall`, component: AllProductsComponent},
  {path: `searchproduct`, component: SearchProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
