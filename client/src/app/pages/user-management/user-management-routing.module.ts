import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { CompleteRoutes, CompleteRoutesName } from "src/app/shared/extensions/CompleteRoutes";
import { StudentComponent } from './pages/student/student.component';

const routes: CompleteRoutes = [
  {
    path: "usermanagement/student",
    component: StudentComponent,
    icon: "person",
    name: "Alunos"
  },
];

export const UserManagementRoutes: CompleteRoutesName = {
  routes,
  name: "Controle de Usuarios",
  icon: "group",
};

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule {}
