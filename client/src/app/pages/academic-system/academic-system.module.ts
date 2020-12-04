import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AcademicSystemRoutingModule } from './academic-system-routing.module';
import { AClassComponent } from './a-class/a-class.component';


@NgModule({
  declarations: [AClassComponent],
  imports: [
    CommonModule,
    AcademicSystemRoutingModule
  ]
})
export class AcademicSystemModule { }
