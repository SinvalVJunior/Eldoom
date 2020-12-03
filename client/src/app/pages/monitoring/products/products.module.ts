import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MaterialModule } from "src/app/material-module";
import { ProductsComponent } from "./products.component";
import { SearchBarComponent } from "./components/search-bar/search-bar.component";
import { ProductsTableComponent } from "./components/products-table/products-table.component";
import { FormsModule } from "@angular/forms";

import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { BrowserModule } from "@angular/platform-browser";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";
import { SharedModule } from "src/app/shared/shared.module";
import { ModalLoaderComponent } from "src/app/shared/components/modal-loader/modal-loader.component";
import { RouterModule } from "@angular/router";
import { LastChangesComponent } from "./components/last-changes/last-changes.component";

@NgModule({
  declarations: [
    ProductsComponent,
    SearchBarComponent,
    ProductsTableComponent,
    ProductDetailsComponent,
    LastChangesComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    SharedModule,
    RouterModule,
  ],
  providers: [LastChangesComponent],
  entryComponents: [ProductDetailsComponent, ModalLoaderComponent, LastChangesComponent],
})
export class ProductsModule {}
