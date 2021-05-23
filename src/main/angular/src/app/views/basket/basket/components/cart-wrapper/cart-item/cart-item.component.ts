import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {getCommonAmountFormatForGrid} from "../../../../../../main/service/common/format-util";
import {MatDialog} from "@angular/material";
import {BasketService} from "../../../services/basket.service";
import {ConfirmationDialogComponent} from "../../../../../../shared/components/confirmation-dialog/confirmation-dialog.component";


@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.scss']
})
export class CartItemComponent implements OnInit {


  @Input('cartItem') cartItem;
  @Input('index') index;


  getSelectedItemsRequested = false;

  onSelectCartItemToEditSubs = new Subscription();


  constructor(private dialog: MatDialog,
              private basketService: BasketService) {
  }

  removeItem() {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent,
      {
        data: {
          title: 'Remove Cart Item',
          description: `<p>Are you sure to remove the item
					 <span class="bold-font">${this.cartItem.productName}</span> ?</p>`
        },
        width: '45%'

      }
    );

    const dialogSubs = dialogRef.afterClosed()
      .subscribe((response) => {
        if (response) {
          this.basketService.removeItemFromBasket(this.cartItem.productID);
        }
        dialogSubs.unsubscribe();
      });
  }

  editItem() {

  }

  ngOnInit() {
  }

  getCommonAmountFormatForGrid(value) {
    return getCommonAmountFormatForGrid(value);
  }

}
