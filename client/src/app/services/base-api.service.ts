import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FilterToParams } from "src/app/shared/Functions/filter-functions";

@Injectable({
  providedIn: "root",
})
export class BaseApiService<TResult> {
  constructor(private api: HttpClient) {}

  urlPath: string = null;

  getFiltered(filter: object): Observable<TResult[]> {
    if (!this.urlPath) return null;
    return this.api.get<TResult[]>(this.urlPath, { params: FilterToParams(filter) });
  }
}
