import { Component, OnInit } from '@angular/core';
import { BaseApiService } from 'src/app/services/base-api.service';
import { CustomSearchBarDefinition, FieldType } from 'src/app/shared/components/custom-search-bar/models/custom-search-bar.model';
import { CustomTableDefinition, ColumnDefinition } from 'src/app/shared/components/custom-table/models/custom-table-data.model';
import { Work } from '../models/work.model';

@Component({
  templateUrl: "./work.component.html",
  styleUrls: ["./work.component.scss"],
})
export class WorkComponent implements OnInit {
  tableDefinition: CustomTableDefinition = new CustomTableDefinition({
    columnDefinitions: [
      {
        name: "alunoNome",
        displayName: "Nome",
        allowSorting: true,
      },
      {
        name: "trabalhoTitulo",
        displayName: "Titulo",
        allowSorting: true,
      },
      {
        name: "dataEnvio",
        displayName: "Data de Envio",
        allowSorting: true,
        getValueFunc: (obj: Work) => {
          return new Date(obj.dataEnvio).toLocaleString();
        },
      },
      {
        name: "dataAvaliacao",
        displayName: "Data de Avaliação",
        allowSorting: true,
        getValueFunc: (obj: Work) => {
          return new Date(obj.dataAvaliacao).toLocaleString();
        },
      },
      {
        name: "nota",
        displayName: "Nota",
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
  values: Work[] = [];
  searchBarDefinition: CustomSearchBarDefinition = new CustomSearchBarDefinition({
    fields: [
      { name: "Nome", type: FieldType.TEXT, filterName: "alunoNome" },
      { name: "Titulo", type: FieldType.TEXT, filterName: "trabalhoTitulo" },
    ],
  });
  searchBarFilter: object = {};

  constructor(private api: BaseApiService<Work>) {
    api.urlPath = "/api/v1/trabalho/autores";
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
