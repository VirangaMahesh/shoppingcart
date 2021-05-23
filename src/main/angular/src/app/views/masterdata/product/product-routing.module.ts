import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductService} from "./services/product.service";
import {ViewProductComponent} from "./components/view-product/view-product.component";


const routes: Routes = [
  {
    path: '',
    resolve: {
      data: ProductService
    },
    component: ViewProductComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
