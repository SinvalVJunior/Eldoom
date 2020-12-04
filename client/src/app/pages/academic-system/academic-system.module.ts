import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { AcademicSystemRoutingModule } from "./academic-system-routing.module";
import { AClassComponent } from "./a-class/a-class.component";
import { FormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/material-module";
import { SharedModule } from "src/app/shared/shared.module";

@NgModule({
  declarations: [AClassComponent],
  imports: [CommonModule, MaterialModule, SharedModule, FormsModule, AcademicSystemRoutingModule],
})
export class AcademicSystemModule {}
