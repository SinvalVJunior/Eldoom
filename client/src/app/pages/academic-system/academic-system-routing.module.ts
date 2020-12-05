import { SubjectsComponent } from './subjects/subjects.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CompleteRoutes, CompleteRoutesName } from 'src/app/shared/extensions/CompleteRoutes';
import { AClassComponent } from './a-class/a-class.component';
import { CourseComponent } from './course/course.component';
import { WorkComponent } from './work/work.component';

const routes: CompleteRoutes = [
  {
    path: "usermanagement/aclass",
    component: AClassComponent,
    icon: "class",
    name: "Turmas",
  },
  {
    path: "usermanagement/course",
    component: CourseComponent,
    icon: "class",
    name: "Cursos",
  },
  {
    path: "usermanagement/subjects",
    component: SubjectsComponent,
    icon: "class",
    name: "Disciplinas",
  },
  {
    path: "usermanagement/work",
    component: WorkComponent,
    icon: "class",
    name: "Trabalhos",
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
