import { Student } from "./../models/student.model";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FilterToParams } from "src/app/shared/Functions/filter-functions";
import { StudentFilter } from "../models/student-filter.model";

@Injectable({
  providedIn: "root",
})
export class StudentApiService {
  constructor(private api: HttpClient) {}

  getStudents(filter: StudentFilter): Observable<Student[]> {
    return this.api.get<Student[]>("/api/v1/aluno", { params: FilterToParams(filter) });
  }
}
