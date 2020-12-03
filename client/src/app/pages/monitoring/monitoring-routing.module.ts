import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { CompleteRoutes, CompleteRoutesName } from "src/app/shared/extensions/CompleteRoutes";
import { ProductsComponent } from "./products/products.component";
import { ProductDetailsComponent } from "./products/components/product-details/product-details.component";

const routes: CompleteRoutes = [
  {
    path: "monitoring/products",
    component: ProductsComponent,
    icon: "web",
    name: "Especificação de Produtos",
    isSvg: false,
  },
  {
    path: "monitoring/products/crud",
    component: ProductDetailsComponent,
    icon: "web",
    name: "Detalhes da Especificação",
    isDisabled: true,
    isSvg: false,
  },
];

export const MonitoringRoutes: CompleteRoutesName = {
  routes,
  name: "Especificações",
  icon: "box",
  isSvg: true,
};

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class MonitoringRoutingModule {}
