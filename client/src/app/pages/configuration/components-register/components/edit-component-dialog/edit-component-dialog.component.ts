import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { ApiService } from "../../services/api.service";
import { ToastService } from "src/app/services/toast.service";

@Component({
  selector: "app-edit-component-dialog",
  templateUrl: "./edit-component-dialog.component.html",
  styleUrls: ["./edit-component-dialog.component.scss"],
})
export class EditComponentDialogComponent {
  coordinations = [];

  data: any;

  constructor(
    private dialogRef: MatDialogRef<EditComponentDialogComponent>,
    private api: ApiService,
    private toast: ToastService,
    @Inject(MAT_DIALOG_DATA) public input
  ) {
    this.coordinations = input.coordinations;
    this.data = input.component;
  }

  ngOnInit(): void {}

  close() {
    this.dialogRef.close();
  }

  async save() {
    if (this.data.coordination.name == "" || this.data.name == "") {
      if (this.data.coordination.name == "") {
        this.data.coordination.name = null;
      }
      if (this.data.name == "") {
        this.data.name = null;
      }
    } else {
      let coordination = this.coordinations.filter((a) => a.name == this.data.coordination.name);

      this.data.coordination.id = coordination[0].id;
      this.data.coordinationId = coordination[0].id;
      let updatedComponent = {
        id: this.data.id,
        name: this.data.name,
        coordination: {
          name: this.data.coordination.name,
          id: this.data.coordinationId,
        },
        coordinationId: this.data.coordinationId,
        modifiedDate: this.data.modDate,
      };
      let updated = await this.update(updatedComponent);
      if (updated != undefined) {
        this.data.modifiedDate = new Date(updated.modifiedDate).toLocaleString();
        this.data.modDate = updated.modifiedDate;
        this.toast.toastrSuccess("Componente editado com sucesso", "X");
      }
    }
    this.dialogRef.close();
  }

  update(element) {
    return this.api.updateComponent(element, element.id).toPromise();
  }
}
