import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {BasketService} from "../../services/basket.service";

@Component({
  selector: 'app-update-basket',
  templateUrl: './update-basket.component.html',
  styleUrls: ['./update-basket.component.scss']
})
export class UpdateBasketComponent implements OnInit {
  basket: any = {};
  onBasketChangesSubs = new Subscription();

  constructor(private basketService: BasketService) {
  }


  ngOnInit() {
  }

}
