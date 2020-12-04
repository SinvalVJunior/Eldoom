import { AcademicSystemRoutes } from './pages/academic-system/academic-system-routing.module';
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MonitoringRoutes } from './pages/monitoring/monitoring-routing.module';
import { UserManagementRoutes } from './pages/user-management/user-management-routing.module';
import { UnauthorizedPageComponent } from "./shared/components/unauthorized-page/unauthorized-page.component";

const routes: Routes = [
  { path: "redirect", redirectTo: "", pathMatch: "full" },
  { path: "", redirectTo: "usermanagement/student", pathMatch: "full" },
  { path: "unauthorized", component: UnauthorizedPageComponent },
  ...UserManagementRoutes.routes,
  ...AcademicSystemRoutes.routes,
  ...MonitoringRoutes.routes,
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
