import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BasketRoutingModule} from './basket-routing.module';
import {BasketService} from "./services/basket.service";
import {UpdateBasketComponent} from './components/update-basket/update-basket.component';
import {CartWrapperComponent} from './components/cart-wrapper/cart-wrapper.component';
import {CartItemComponent} from './components/cart-wrapper/cart-item/cart-item.component';
import {
  MatCardModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule, MatInputModule,
  MatPaginatorModule,
  MatTableModule
} from "@angular/material";
import {FlexModule} from "@angular/flex-layout";
import {ProductListComponent} from './components/product-list/product-list.component';
import {AddProductComponent} from './components/add-product/add-product.component';
import {SharedModule} from "../../../shared/shared.module";


@NgModule({
  declarations: [UpdateBasketComponent, CartWrapperComponent, CartItemComponent, ProductListComponent, AddProductComponent],
  imports: [
    CommonModule,
    BasketRoutingModule,
    MatIconModule,
    FlexModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    SharedModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [
    BasketService
  ]
})
export class BasketModule {
}
