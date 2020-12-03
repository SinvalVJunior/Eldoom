import { Component, OnInit, Input, Output, EventEmitter, SimpleChanges } from "@angular/core";
import { ApiService } from "../../services/api.service";
import { ConfirmationModalService } from "src/app/shared/components/confrimation-modal/services/confirmation-modal.service";
import { MatDialog } from "@angular/material/dialog";
import { EditComponentDialogComponent } from "../edit-component-dialog/edit-component-dialog.component";
import { ToastService } from "src/app/services/toast.service";
import { NewComponentDialogComponent } from "../new-component-dialog/new-component-dialog.component";
import { PageEvent } from "@angular/material/paginator";

@Component({
  selector: "app-table",
  templateUrl: "./table.component.html",
  styleUrls: ["./table.component.scss"],
})
export class TableComponent implements OnInit {
  @Input() set newComponent(value: any) {
    if (value != undefined && value != null) {
      this.pushComponent(value);
    }
  }
  @Input() data: any;
  @Input() gettingData: boolean;
  @Input() nothingHappened: boolean;
  @Input() limit: number;
  @Input() pageIndex: number;
  @Input() resultsCount: number;
  @Output("pageEvent") pageEvent = new EventEmitter<PageEvent>();

  displayedColumns: string[] = ["coordination", "name", "modifiedDate", "edit", "remove"];
  dataSource = [];

  coordinations: any;

  constructor(
    private dialog: MatDialog,
    private api: ApiService,
    private confirmationModal: ConfirmationModalService,
    private toast: ToastService
  ) {}

  ngOnInit(): void {}

  async getFilterOptions() {
    let filterOptions = await this.getFilterData();
    if (filterOptions != undefined) {
      this.coordinations = filterOptions.coordinations;
    }
  }

  getFilterData(): Promise<any> {
    return this.api.getFilterData().toPromise();
  }

  async ngOnChanges(changes: SimpleChanges) {
    if (this.limit && changes.limit) {
      this.limit = changes.limit.currentValue;
    }
    if (this.pageIndex && changes.pageIndex) {
      this.pageIndex = changes.pageIndex.currentValue;
    }
    if (this.data && changes.data) {
      if (!this.coordinations) {
        this.gettingData = true;
        await this.getFilterOptions();
        this.gettingData = false;
      }
      let table = this.data;
      this.dataSource = [];
      for (let i = 0; i < table.length; i++) {
        let coordination = this.coordinations.filter((a) => a.id == table[i].coordinationId);
        let component = {
          id: table[i].id,
          name: table[i].name,
          coordination: {
            name: coordination[0].name,
            id: coordination[0].id,
          },
          coordinationId: table[i].coordinationId,
          modifiedDate: new Date(table[i].modifiedDate).toLocaleString(),
          modDate: table[i].modifiedDate,
        };
        this.dataSource.push(component);
      }
    }
  }

  pushComponent(value) {
    this.dataSource.push(value.newComponent);
    this.dataSource = [...this.dataSource];
  }

  save(element) {
    return this.api.newComponent(element).toPromise();
  }

  confirmDeletion(element) {
    this.confirmationModal.openConfirmationModal({
      title: "Confirmar Exclusão",
      description: "Realmente deseja excluir esse componente?",
    });
    const subs = this.confirmationModal.confirmationResult.subscribe((result) => {
      if (result) this.deleteComponent(element);
      subs.unsubscribe();
    });
  }

  async deleteComponent(element) {
    let response = await this.deleteComponentApi(element);
    if (response != undefined) {
      this.toast.toastrSuccess("Componente excluído com sucesso", "X");
    }
    let index = this.dataSource.indexOf(element);
    this.dataSource.splice(index, 1);
    this.dataSource = [...this.dataSource];
  }

  deleteComponentApi(element) {
    return this.api.deleteComponent(element.id).toPromise();
  }

  openEditComponentDialog(component) {
    let clone = JSON.parse(JSON.stringify(component));
    let dialogRef = this.dialog.open(EditComponentDialogComponent, {
      disableClose: true,
      data: {
        component: clone,
        coordinations: this.coordinations,
      },
    });
    dialogRef.afterClosed().subscribe((updated: any) => {
      if (updated) {
        component = updated.updated;
        for (let i = 0; i < this.dataSource.length; i++) {
          if (this.dataSource[i].id == component.id) {
            this.dataSource[i] = component;
          }
        }
        this.dataSource = [...this.dataSource];
      }
    });
  }

  onPageChange(eventData) {
    this.pageEvent.emit(eventData);
  }
}
