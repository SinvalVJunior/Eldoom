import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FilterToParams } from "src/app/shared/Functions/filter-functions";
import { TeacherFilter } from '../models/teacher-filter.model';
import { Teacher } from '../models/teacher.model';

@Injectable({
  providedIn: "root",
})
export class TeacherApiService {
  constructor(private api: HttpClient) {}

  getFiltered(filter: TeacherFilter): Observable<Teacher[]> {
    return this.api.get<Teacher[]>("/api/v1/professor", { params: FilterToParams(filter) });
  }
}
