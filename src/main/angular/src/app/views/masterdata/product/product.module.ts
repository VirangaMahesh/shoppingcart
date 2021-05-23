import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProductRoutingModule} from './product-routing.module';
import {ViewProductComponent} from './components/view-product/view-product.component';
import {ProductService} from "./services/product.service";
import {MatCardModule, MatFormFieldModule, MatInputModule, MatTableModule} from "@angular/material";
import {MatPaginatorModule} from '@angular/material/paginator';


@NgModule({
  declarations: [ViewProductComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [
    ProductService
  ],
})
export class ProductModule {
}
