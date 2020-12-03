import { CompleteRoute, CompleteRoutesName } from "./../../shared/extensions/CompleteRoutes";
import { MonitoringRoutes } from "./../../pages/monitoring/monitoring-routing.module";
import { ConfigurationRoutes } from "./../../pages/configuration/configuration-routing.module";
import { MultipleRoutes } from "src/app/shared/extensions/CompleteRoutes";
import { Component, OnInit } from "@angular/core";
import { Router, RouterEvent, NavigationEnd } from "@angular/router";
import { ConfirmationModalService } from "src/app/shared/components/confrimation-modal/services/confirmation-modal.service";
import { UserManagementRoutes } from 'src/app/pages/user-management/user-management-routing.module';

type CompleteRouteWithParent = CompleteRoute & { parent: CompleteRoutesName };

@Component({
  selector: "app-menu",
  templateUrl: "./menu.component.html",
  styleUrls: ["./menu.component.scss"],
})
export class MenuComponent implements OnInit {
  multipleRoutes: MultipleRoutes = [];
  currentCompleteRouteName: CompleteRouteWithParent;
  routesArrayWithParents: CompleteRouteWithParent[];
  currentPath: string = "";

  constructor(router: Router, public confirmationModal: ConfirmationModalService) {
    this.multipleRoutes.push(MonitoringRoutes, ConfigurationRoutes, UserManagementRoutes);

    /**
     * Cria um Array que contem todas as rotas em apenas
     * uma dimensao e uma referencia ao seu elemento pai.
     * Necessario para definir qual a pagina atual.
     */
    this.routesArrayWithParents = [];
    this.multipleRoutes.forEach((completeRoutesName) => {
      this.routesArrayWithParents.push(
        ...completeRoutesName.routes.map((d) => {
          d.isSelected = false;
          return Object.assign(d, { parent: completeRoutesName });
        })
      );
    });

    router.events.subscribe((val: RouterEvent) => {
      if (val instanceof NavigationEnd) {
        if (val.url) {
          this.currentPath =
            val.url.split("?")[0] !== "/" ? val.url.split("?")[0] : val.urlAfterRedirects;
          // Overkill para o problema
          // while (this.currentPath[0] === "\\") this.currentPath = this.currentPath.substr(1);
          if (this.currentPath[0] === "/") this.currentPath = this.currentPath.substr(1);
        }

        if (this.currentCompleteRouteName) {
          this.currentCompleteRouteName.isSelected = false;
          this.currentCompleteRouteName.parent.isSelected = false;
        }

        this.currentCompleteRouteName = this.routesArrayWithParents.find(
          (d) =>
            d.path.localeCompare(this.currentPath, "default", {
              sensitivity: "base",
            }) === 0
        );

        if (this.currentCompleteRouteName) {
          this.currentCompleteRouteName.isSelected = true;
          this.currentCompleteRouteName.parent.isSelected = true;
        }
      }
    });
  }

  ngOnInit(): void {}
}
