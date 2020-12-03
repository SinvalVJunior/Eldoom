import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { CompleteRoutes, CompleteRoutesName } from "src/app/shared/extensions/CompleteRoutes";
import { ComponentsRegisterComponent } from "./components-register/components-register.component";

const routes: CompleteRoutes = [
  {
    path: "configuration/components-register",
    component: ComponentsRegisterComponent,
    icon: "create_new_folder",
    name: "Cadastro de Componentes",
    isSvg: false,
  },
];

export const ConfigurationRoutes: CompleteRoutesName = {
  routes,
  name: "Configurações",
  icon: "gear-single-color",
  isSvg: true,
};

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigurationRoutingModule {}
