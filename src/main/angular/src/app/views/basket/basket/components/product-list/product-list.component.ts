import {AfterViewInit, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Subscription} from "rxjs";
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {getCommonAmountFormatForGrid} from "../../../../../main/service/common/format-util";
import {BasketService} from "../../services/basket.service";
import {AlertServiceService} from "../../../../../main/service/common/alert-service.service";
import * as _ from "lodash"

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit, OnDestroy, AfterViewInit {


  onProductChangeSubs = new Subscription();
  onBasketItemRemoveSubs = new Subscription();
  products = [];
  dataSource = new MatTableDataSource(this.products);
  idWiseProductMap: any = {};
  idWiseQtyMap: any = {};

  @ViewChild(MatPaginator, null) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor(private basketService: BasketService,
              private alertServiceService: AlertServiceService) {
  }

  ngOnInit() {
    this.onProductChangeSubs = this.basketService.onProductsChange
      .subscribe(data => {
        this.products = this.basketService.products;
        this.dataSource = new MatTableDataSource(this.products);
      });

    this.onBasketItemRemoveSubs = this.basketService.onRemoveBasketChange
      .subscribe(productID => {
        this.idWiseProductMap[productID] = null;
        this.idWiseQtyMap[productID] = 0;
      });

  }

  addItem(productDTO) {
    if (this.idWiseQtyMap[productDTO.productID] == null || this.idWiseQtyMap[productDTO.productID] == 0) {
      this.idWiseProductMap[productDTO.productID] = productDTO;
      this.idWiseQtyMap[productDTO.productID] = 0;
    }
    this.idWiseQtyMap[productDTO.productID] = this.idWiseQtyMap[productDTO.productID] + 1;
    this.updateBasketRQ();
  }


  updateItemQty(value, productDTO) {
    if (_.isNaN(value)) {
      this.idWiseProductMap[productDTO.productID] = null;
      this.idWiseQtyMap[productDTO.productID] = 0;
    } else if (value != null && value > 0) {
      this.idWiseProductMap[productDTO.productID] = productDTO;
      this.idWiseQtyMap[productDTO.productID] = parseInt(value);
    } else {
      this.idWiseProductMap[productDTO.productID] = null;
      this.idWiseQtyMap[productDTO.productID] = 0;
    }
    this.updateBasketRQ();
  }

  removeItem(productDTO) {
    if (this.idWiseQtyMap[productDTO.productID] == null || this.idWiseQtyMap[productDTO.productID] == 0) {

      this.alertServiceService.showToaster("No Item to remove", "WARNING");
      return;
    }

    this.idWiseQtyMap[productDTO.productID] = this.idWiseQtyMap[productDTO.productID] - 1;

    if (this.idWiseQtyMap[productDTO.productID] == 0) {
      this.idWiseProductMap[productDTO.productID] = null;
      this.idWiseQtyMap[productDTO.productID] = 0;
    }
    this.updateBasketRQ();
  }

  hasSelectedItem(productDTO) {
    return this.idWiseQtyMap[productDTO.productID] != null || this.idWiseQtyMap[productDTO.productID] != 0;
  }

  ngOnDestroy(): void {

    this.onProductChangeSubs.unsubscribe();
    this.onBasketItemRemoveSubs.unsubscribe();
  }

  updateBasketRQ() {
    let basketCalculateRQ = this.basketService.basketCalculateRQ;
    let productIDs = _.keys(this.idWiseProductMap);
    let basketItemList = [];
    let that = this;
    _.forEach(this.idWiseQtyMap, function (qty, id) {
      if (qty > 0) {
        basketItemList.push({
          productID: id,
          productCode: that.idWiseProductMap[id].productCode,
          productName: that.idWiseProductMap[id].productName,
          purchaseQuantity: qty,
        })
      }
    });
    this.basketService.updateBasketRQ(basketItemList)
  }

  displayedColumns: string[] = ['productID', 'productCode', 'productName', 'cartonSize', 'cartonPrice', 'perUnitPrice', "action"];


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getCommonAmountFormatForGrid(value) {
    return getCommonAmountFormatForGrid(value);
  }
}
