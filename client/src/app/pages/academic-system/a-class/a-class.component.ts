import { Component, OnInit } from "@angular/core";
import { BaseApiService } from "src/app/services/base-api.service";
import {
  CustomSearchBarDefinition,
  FieldType,
} from "src/app/shared/components/custom-search-bar/models/custom-search-bar.model";
import {
  CustomTableDefinition,
  ColumnDefinition,
} from "src/app/shared/components/custom-table/models/custom-table-data.model";
import { AClassFilter } from "../models/a-class-filter.model";
import { AClass } from "../models/a-class.model";

@Component({
  templateUrl: "./a-class.component.html",
  styleUrls: ["./a-class.component.scss"],
})
export class AClassComponent implements OnInit {
  tableDefinition: CustomTableDefinition = new CustomTableDefinition({
    columnDefinitions: [
      {
        name: "codigo",
        displayName: "Codigo",
        allowSorting: true,
      },
      {
        name: "professorNome",
        displayName: "Professor",
        allowSorting: true,
      },
      {
        name: "medianotaturma",
        displayName: "Media da Turma",
        allowSorting: true,
      },
      {
        name: "Editar",
        customHeaderClass: "column-small",
        customCellClass: "column-small",
        isButton: true,
        iconSvg: "edit",
        onClick: (element) => {
          console.log("Edit", element);
        },
      },
      {
        name: "Excluir",
        customHeaderClass: "column-small",
        customCellClass: "column-small",
        isButton: true,
        iconSvg: "delete",
        onClick: (element) => {
          console.log("Delete", element);
        },
      },
    ] as ColumnDefinition[],
    paginate: true,
    frontPaginateSort: true,
  });
  values: AClass[] = [];
  searchBarDefinition: CustomSearchBarDefinition = new CustomSearchBarDefinition({
    fields: [
      { name: "Codigo", type: FieldType.TEXT, filterName: "codigo" },
      { name: "Professor", type: FieldType.TEXT, filterName: "professorNome" },
      { name: "Disciplina", type: FieldType.TEXT, filterName: "disciplinaNome" },
    ],
  });
  searchBarFilter: AClassFilter = {};

  constructor(private api: BaseApiService<AClass>) {
    api.urlPath = "/api/v1/turma";
  }

  getData() {
    this.api.getFiltered(this.searchBarFilter).subscribe(
      (data) => {
        this.values = data;
      },
      (error) => console.error(error)
    );
  }

  ngOnInit() {
    this.getData();
  }
}
