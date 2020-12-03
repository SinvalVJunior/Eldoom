import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ConfigurationRoutingModule } from "./configuration-routing.module";
import { ComponentsRegisterModule } from "./components-register/components-register.module";

@NgModule({
  imports: [
    CommonModule,
    ConfigurationRoutingModule,
    ComponentsRegisterModule,
  ],
  exports: [
    ComponentsRegisterModule
  ],
})
export class ConfigurationModule {}
