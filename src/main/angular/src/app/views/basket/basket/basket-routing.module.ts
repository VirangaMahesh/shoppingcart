import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BasketService} from "./services/basket.service";
import {UpdateBasketComponent} from "./components/update-basket/update-basket.component";


const routes: Routes = [
  {
    path: '',
    resolve: {
      data: BasketService
    },
    component: UpdateBasketComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BasketRoutingModule {
}
