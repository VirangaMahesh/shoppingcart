import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ProductModule} from "./views/masterdata/product/product.module";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule, MatIconModule, MatMenuModule, MatSidenavModule, MatSnackBarModule} from "@angular/material";
import {MatPaginatorModule} from '@angular/material/paginator';
import {SharedModule} from "./shared/shared.module";
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProductModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatPaginatorModule,
    SharedModule,
    FlexLayoutModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule
  ],
  providers: [],
  exports: [
    HttpClientModule,
    MatSnackBarModule,
    MatPaginatorModule,
    SharedModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
