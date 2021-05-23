import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material";
import {Subscription} from "rxjs";
import {ProductService} from "../../services/product.service";
import {getCommonAmountFormatForGrid} from "../../../../../main/service/common/format-util";
import {AfterViewInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.scss']
})
export class ViewProductComponent implements OnInit, OnDestroy, AfterViewInit  {


  onProductChangeSubs = new Subscription();
  products = [];
  dataSource = new MatTableDataSource(this.products);

  @ViewChild(MatPaginator,null) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.onProductChangeSubs = this.productService.onProductsChange
      .subscribe(data => {
        this.products = this.productService.products;
        this.dataSource = new MatTableDataSource(this.products);
      });

  }

  ngOnDestroy(): void {

    this.onProductChangeSubs.unsubscribe();
  }

  displayedColumns: string[] = ['productID', 'productCode', 'productName', 'cartonSize', 'cartonPrice', 'perUnitPrice' ];


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getCommonAmountFormatForGrid(value) {
    return getCommonAmountFormatForGrid(value);
  }

}
