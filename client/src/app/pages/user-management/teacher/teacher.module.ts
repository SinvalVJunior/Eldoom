import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TeacherComponent } from './teacher.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/material-module';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [TeacherComponent],
  imports: [CommonModule, MaterialModule, SharedModule, FormsModule],
})
export class TeacherModule {}
