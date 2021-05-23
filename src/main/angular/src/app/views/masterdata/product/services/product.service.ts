import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {BehaviorSubject, Observable} from "rxjs";
import {SETTINGS} from "../../../../main/setting/common.setting";
import {DataService} from "../../../../main/service/data/data.service";

@Injectable()
export class ProductService implements Resolve<any> {

  constructor(private dataService: DataService) {
  }

  products: any = [];
  onProductsChange: BehaviorSubject<any> = new BehaviorSubject([]);


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
        this.onProductsChange.next(response.result);
        this.products = response.result.products;
        resolve(response);
      }, reject);
    });
  }
}
