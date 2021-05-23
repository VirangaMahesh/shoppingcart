import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {DataService} from "../../../../main/service/data/data.service";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {SETTINGS} from "../../../../main/setting/common.setting";
import * as _ from "lodash"

@Injectable()
export class BasketService implements Resolve<any> {

  constructor(private dataService: DataService) {
  }


  basketCalculateRQ: any = {};
  products: any = [];
  onProductsChange: BehaviorSubject<any> = new BehaviorSubject([]);
  basket: any = {};
  onBasketChange: BehaviorSubject<any> = new BehaviorSubject({});
  onRemoveBasketChange: Subject<any> = new Subject();


  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {

    return new Promise((resolve, reject) => {

      Promise.all([
        this.getAvailableProducts({})
      ]).then(
        () => {
          resolve();
        },
        reject
      );
    });
  }

  getAvailableProducts(searchData?): Promise<any> {
    return new Promise((resolve, reject) => {
      this.dataService.post(
        SETTINGS.ENDPOINTS.getAvailableProducts, searchData).subscribe((response: any) => {
        this.products = response.result.products;
        this.onProductsChange.next(response.result);
        resolve(response);
      }, reject);
    });
  }

  calculateBasket(calculateData?): Promise<any> {
    return new Promise((resolve, reject) => {
      this.dataService.post(
        SETTINGS.ENDPOINTS.calculateBasket, calculateData).subscribe((response: any) => {
        this.basket = response.result;
        this.onBasketChange.next(response.result);
        resolve(response);
      }, reject);
    });
  }


  updateBasketRQ(basketItemList) {
    this.basketCalculateRQ = {
      basketItemList: basketItemList
    };
    this.calculateBasket(this.basketCalculateRQ)
  }

  removeItemFromBasket(productID) {
    let basketItemList = _.cloneDeep(this.basketCalculateRQ.basketItemList);
    let updatedBasketItemList = _.remove(basketItemList, function (basketItem) {
      return basketItem.productID != productID;
    });
    this.basketCalculateRQ = {
      basketItemList: updatedBasketItemList
    };
    this.onRemoveBasketChange.next(productID);
    this.calculateBasket(this.basketCalculateRQ)
  }

  updateBasket(basket) {
    this.basket = basket;
  }
}

