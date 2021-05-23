import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmationDialogComponent} from './components/confirmation-dialog/confirmation-dialog.component';
import {FlexModule} from "@angular/flex-layout";
import {MatButtonModule} from "@angular/material";

@NgModule({
  declarations: [ConfirmationDialogComponent],
  imports: [
    CommonModule,
    FlexModule,
    MatButtonModule,
  ], entryComponents: [
    ConfirmationDialogComponent
  ]
})
export class SharedModule {
}
