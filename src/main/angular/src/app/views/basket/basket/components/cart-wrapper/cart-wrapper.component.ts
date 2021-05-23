import {Component, OnDestroy, OnInit} from '@angular/core';
import {getCommonAmountFormatForGrid} from "../../../../../main/service/common/format-util";
import {BasketService} from "../../services/basket.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-cart-wrapper',
  templateUrl: './cart-wrapper.component.html',
  styleUrls: ['./cart-wrapper.component.scss']
})
export class CartWrapperComponent implements OnInit, OnDestroy {

  basket: any = {};
  onBasketChangesSubs = new Subscription();
  cardItems: any = [];

  constructor(private basketService: BasketService) {
  }

  ngOnInit() {
    this.onBasketChangesSubs = this.basketService.onBasketChange.subscribe(data => {
      this.basket = this.basketService.basket;
      this.cardItems = this.basket ? (this.basket.basketItemDTOList || []) : [];
    });

  }

  ngOnDestroy(): void {
    this.onBasketChangesSubs.unsubscribe();
  }


  hasCart() {
    return this.basket && this.basket.basketItemDTOList && this.basket.basketItemDTOList.length > 0;
  }

  getTotalItems() {
    return this.cardItems.length;
  }

  getTotalAmount() {
    return this.basket && getCommonAmountFormatForGrid(this.basket.totalBasketAmount);
  }

  getDiscountAmount() {
    return this.basket && getCommonAmountFormatForGrid(this.basket.totalDiscountAmount);
  }

  hasDiscount() {
    return this.basket && this.basket.totalDiscountAmount > 0;
  }

  getNetAmount() {
    return this.basket && getCommonAmountFormatForGrid(this.basket.totalNetAmount);
  }

  calculatePrices() {
    this.basketService.calculateBasket({
      basketItemList: this.basket.basketItemDTOList
    })
  }

}
