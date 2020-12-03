import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MonitoringRoutingModule } from "./monitoring-routing.module";
import { ProductsModule } from "./products/products.module";

@NgModule({
  imports: [CommonModule, MonitoringRoutingModule, ProductsModule],
  exports: [ProductsModule],
})
export class MonitoringModule {}
