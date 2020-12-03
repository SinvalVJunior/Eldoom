import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ComponentsRegisterComponent } from "./components-register.component";
import { FilterComponent } from "./components/filter/filter.component";
import { TableComponent } from "./components/table/table.component";
import { MaterialModule } from "src/app/material-module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { OwlDateTimeModule, OwlNativeDateTimeModule } from "ng-pick-datetime";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NewComponentDialogComponent } from "./components/new-component-dialog/new-component-dialog.component";
import { EditComponentDialogComponent } from "./components/edit-component-dialog/edit-component-dialog.component";

@NgModule({
  declarations: [
    ComponentsRegisterComponent,
    TableComponent,
    FilterComponent,
    NewComponentDialogComponent,
    EditComponentDialogComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
  ],
  entryComponents: [NewComponentDialogComponent, EditComponentDialogComponent],
})
export class ComponentsRegisterModule {}
