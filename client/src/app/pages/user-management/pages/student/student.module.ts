import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentComponent } from './student.component';
import { MaterialModule } from 'src/app/material-module';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [StudentComponent],
  imports: [CommonModule, MaterialModule, SharedModule, FormsModule],
})
export class StudentModule {}
