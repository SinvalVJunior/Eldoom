import { Component, Inject, OnInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { ToastService } from "src/app/services/toast.service";

@Component({
  selector: "app-last-changes",
  templateUrl: "./last-changes.component.html",
  styleUrls: ["./last-changes.component.scss"],
})
export class LastChangesComponent implements OnInit {
  changes;

  constructor(
    public dialogRef: MatDialogRef<LastChangesComponent>,
    protected toast: ToastService,
    @Inject(MAT_DIALOG_DATA) public input: any
  ) {
    this.changes = input.changes;
  }

  ngOnInit(): void {}

  close() {
    this.dialogRef.close();
  }
}
