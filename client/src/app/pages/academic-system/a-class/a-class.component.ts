import { Component, OnInit } from '@angular/core';
import { BaseApiService } from 'src/app/services/base-api.service';
import { CustomSearchBarDefinition, FieldType } from 'src/app/shared/components/custom-search-bar/models/custom-search-bar.model';
import { CustomTableDefinition, ColumnDefinition } from 'src/app/shared/components/custom-table/models/custom-table-data.model';
import { Teacher } from '../../user-management/models/teacher.model';
import { AClassFilter } from '../models/AClass-filter.model';
import { AClass } from '../models/AClass.model';

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
  values: AClass[] = [];
  searchBarDefinition: CustomSearchBarDefinition = new CustomSearchBarDefinition({
    fields: [{ name: "Registro", type: FieldType.TEXT, filterName: "id" }],
  });
  searchBarFilter: AClassFilter = {};

  constructor(private api: BaseApiService<Teacher>) {
    api.urlPath = "/api/v1/professor";
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
