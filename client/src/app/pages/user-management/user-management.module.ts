import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { UserManagementRoutingModule } from "./user-management-routing.module";
import { StudentModule } from './student/student.module';
import { TeacherModule } from './teacher/teacher.module';

@NgModule({
  imports: [CommonModule, UserManagementRoutingModule, StudentModule, TeacherModule],
  exports: [],
  declarations: [],
})
export class UserManagementModule {}
