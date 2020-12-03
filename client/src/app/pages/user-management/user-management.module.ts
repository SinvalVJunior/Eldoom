import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { UserManagementRoutingModule } from "./user-management-routing.module";
import { StudentModule } from './pages/student/student.module';

@NgModule({
  imports: [CommonModule, UserManagementRoutingModule, StudentModule],
  exports: [],
  declarations: [],
})
export class UserManagementModule {}
