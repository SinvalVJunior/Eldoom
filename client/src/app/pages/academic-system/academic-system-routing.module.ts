import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CompleteRoutes, CompleteRoutesName } from 'src/app/shared/extensions/CompleteRoutes';
import { AClassComponent } from './a-class/a-class.component';

const routes: CompleteRoutes = [
  {
    path: "usermanagement/aclass",
    component: AClassComponent,
    icon: "class",
    name: "Turma",
  },
];

export const AcademicSystemRoutes: CompleteRoutesName = {
  routes,
  name: "Sistema Academico",
  icon: "cast_for_education",
};

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AcademicSystemRoutingModule { }
