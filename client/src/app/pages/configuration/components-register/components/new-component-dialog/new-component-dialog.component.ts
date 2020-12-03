import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { ApiService } from "../../services/api.service";
import { ToastService } from "src/app/services/toast.service";

@Component({
  selector: "app-new-component-dialog",
  templateUrl: "./new-component-dialog.component.html",
  styleUrls: ["./new-component-dialog.component.scss"],
})
export class NewComponentDialogComponent implements OnInit {
  coordinations = [];
  data: any;

  constructor(
    private dialogRef: MatDialogRef<NewComponentDialogComponent>,
    private api: ApiService,
    private toast: ToastService,
    @Inject(MAT_DIALOG_DATA) public input
  ) {
    this.coordinations = input.coordinations;
    this.data = {
      id: null,
      name: "",
      coordination: {
        id: null,
        name: "",
      },
      coordinationId: null,
    };
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
      let newComponent = {
        name: this.data.name,
        coordination: {
          name: this.data.coordination.name,
          id: this.data.coordinationId,
        },
        coordinationId: this.data.coordinationId,
      };
      let saved = await this.saveComponent(newComponent);
      this.data.id = saved.id;
      this.data.modifiedDate = new Date(saved.modifiedDate).toLocaleString();
      this.data.modDate = saved.modifiedDate;
      this.toast.toastrSuccess("Componente cadastrado com sucesso!", "X");
      this.dialogRef.close();
    }
  }

  saveComponent(element) {
    return this.api.newComponent(element).toPromise();
  }
}
