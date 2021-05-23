import { NgModule } from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';


const routes: Routes = [
  {path: 'basket', loadChildren:  './views/basket/basket/basket.module#BasketModule'},
  {path: 'product', loadChildren:  './views/masterdata/product/product.module#ProductModule'},
  {path: '**', redirectTo: 'product', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
