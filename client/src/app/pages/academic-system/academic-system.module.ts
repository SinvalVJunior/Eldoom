import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { AcademicSystemRoutingModule } from "./academic-system-routing.module";
import { AClassComponent } from "./a-class/a-class.component";
import { FormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/material-module";
import { SharedModule } from "src/app/shared/shared.module";
import { WorkComponent } from './work/work.component';
import { CourseComponent } from './course/course.component';
import { SubjectsComponent } from './subjects/subjects.component';

@NgModule({
  declarations: [AClassComponent, WorkComponent, CourseComponent, SubjectsComponent],
  imports: [CommonModule, MaterialModule, SharedModule, FormsModule, AcademicSystemRoutingModule],
})
export class AcademicSystemModule {}
