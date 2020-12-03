import { StudentFilter } from "./../../models/student-filter.model";
import { Component, OnInit } from "@angular/core";
import {
  CustomSearchBarDefinition,
  FieldType,
} from "src/app/shared/components/custom-search-bar/models/custom-search-bar.model";
import {
  ColumnDefinition,
  CustomTableDefinition,
} from "src/app/shared/components/custom-table/models/custom-table-data.model";
import { Student } from "../../models/student.model";
import { StudentApiService } from "../../services/student-api.service";

@Component({
  selector: "app-student",
  templateUrl: "./student.component.html",
  styleUrls: ["./student.component.scss"],
})
export class StudentComponent implements OnInit {
  tableDefinition: CustomTableDefinition = new CustomTableDefinition({
    columnDefinitions: [
      {
        name: "matricula",
        displayName: "Matricula",
        allowSorting: true,
      },
      {
        name: "nome",
        displayName: "Nome",
        allowSorting: true,
      },
      {
        name: "dataDeMatricula",
        displayName: "Data de Matricula",
        allowSorting: true,
        getValueFunc: (obj: Student) => {
          return new Date(obj.dataDeMatricula).toLocaleString();
        },
      },
      {
        name: "dataDeNascimento",
        displayName: "Data de Nascimento",
        allowSorting: true,
        getValueFunc: (obj) => {
          return new Date(obj.dataDeMatricula).toLocaleString();
        },
      },
      {
        name: "Detalhes",
        customHeaderClass: "column-small",
        customCellClass: "column-small",
        isButton: true,
        iconSvg: "eye",
        onClick: (element) => {
          console.log("Detail", element);
        },
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
  values: Student[] = [];
  //   =    [
  //   {
  //     id: 0,
  //     matricula: 1,
  //     nome: "Test1",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 2,
  //     nome: "Test2",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 3,
  //     nome: "Test3",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 4,
  //     nome: "Test4",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 7,
  //     nome: "Test7",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 5,
  //     nome: "Test5",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  //   {
  //     id: 0,
  //     matricula: 6,
  //     nome: "Test6",
  //     dataDeMatricula: new Date().toISOString(),
  //     dataDeNascimento: new Date().toISOString(),
  //   },
  // ];
  searchBarDefinition: CustomSearchBarDefinition = new CustomSearchBarDefinition({
    fields: [
      { name: "Matricula", type: FieldType.TEXT, filterName: "matricula" },
      {
        name: "Data de Matricula",
        type: FieldType.DATE_RANGE,
        filterName: "matriculaDateRange",
        defaultValue: [
          new Date(new Date().getFullYear() - 1, 1),
          new Date(new Date().getFullYear() + 1, 1),
        ],
      },
      // Select Example
      // {
      //   name: "ID",
      //   type: FieldType.SELECT,
      //   filterName: "id",
      //   options: [null, 1, 2, 3, 4, 5, 6],
      //   defaultValue: 1,
      // },
    ],
  });
  searchBarFilter: StudentFilter = {};

  constructor(private studentApi: StudentApiService) {
    (window as any).test = this;
  }

  getStudents() {
    this.studentApi.getStudents(this.searchBarFilter).subscribe(
      (data) => {
        this.values = data;
      },
      (error) => console.error(error)
    );
  }

  ngOnInit() {
    this.getStudents();
  }
}
