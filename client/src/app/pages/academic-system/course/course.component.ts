import { Component, OnInit } from '@angular/core';
import { BaseApiService } from 'src/app/services/base-api.service';
import { CustomSearchBarDefinition, FieldType } from 'src/app/shared/components/custom-search-bar/models/custom-search-bar.model';
import { CustomTableDefinition, ColumnDefinition } from 'src/app/shared/components/custom-table/models/custom-table-data.model';
import { Course } from '../models/course.model';

@Component({
  templateUrl: "./course.component.html",
  styleUrls: ["./course.component.scss"],
})
export class CourseComponent implements OnInit {
  tableDefinition: CustomTableDefinition = new CustomTableDefinition({
    columnDefinitions: [
      {
        name: "codigo",
        displayName: "Codigo",
        allowSorting: true,
      },
      {
        name: "nome",
        displayName: "Nome",
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
  values: Course[] = [];
  searchBarDefinition: CustomSearchBarDefinition = new CustomSearchBarDefinition({
    fields: [
      { name: "Codigo", type: FieldType.TEXT, filterName: "codigo" },
      { name: "Nome", type: FieldType.TEXT, filterName: "nome" },
    ],
  });
  searchBarFilter: object = {};

  constructor(private api: BaseApiService<Course>) {
    api.urlPath = "/api/v1/curso";
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
