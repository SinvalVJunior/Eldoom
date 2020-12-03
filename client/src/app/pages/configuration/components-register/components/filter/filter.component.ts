import { Component, OnInit, EventEmitter, Output } from "@angular/core";
import { ApiService } from "../../services/api.service";
import { NewComponentDialogComponent } from "../new-component-dialog/new-component-dialog.component";
import { MatDialog } from "@angular/material/dialog";

@Component({
  selector: "app-filter",
  templateUrl: "./filter.component.html",
  styleUrls: ["./filter.component.scss"],
})
export class FilterComponent implements OnInit {
  @Output("formReceived") form = new EventEmitter<any>();
  @Output("componentReceived") newComponent = new EventEmitter<any>();
  filterOptions: any;
  coordinations: any;
  formData = {
    name: null,
    coordinationId: null,
  };

  constructor(private api: ApiService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.getFilterOptions();
    this.form.emit(this.formData);
  }

  async getFilterOptions() {
    this.filterOptions = await this.getFilterData();
    if (this.filterOptions != undefined) {
      this.coordinations = this.filterOptions.coordinations;
      this.coordinations.unshift({ id: null, name: "-- Nenhum --" });
    }
  }

  getFilterData(): Promise<any> {
    return this.api.getFilterData().toPromise();
  }

  submitForm() {
    this.form.emit(this.formData);
  }

  clearFilter() {
    this.formData = {
      name: null,
      coordinationId: null,
    };
  }

  openNewComponentDialog() {
    let coordination = new Array();
    if (this.formData.coordinationId != null) {
      coordination = this.coordinations.filter((c) => c.id == this.formData.coordinationId);
    } else {
      coordination = this.coordinations;
    }
    let dialogRef = this.dialog.open(NewComponentDialogComponent, {
      disableClose: true,
      data: {
        coordinations: coordination,
      },
    });
    dialogRef.afterClosed().subscribe((newComponent: any) => {
      if (newComponent != undefined) {
        this.newComponent.emit(newComponent);
      }
    });
  }
}
