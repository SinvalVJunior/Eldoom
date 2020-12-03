import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { map, catchError, retry } from "rxjs/operators";
import { Observable, throwError } from "rxjs";
import { ComponentsRegisterModule } from "../components-register.module";
import { Data } from "@angular/router";

@Injectable({ providedIn: ComponentsRegisterModule })
export class ApiService {
  constructor(private api: HttpClient) {}

  newComponent(component): Observable<any> {
    return this.api.post("common/v1/components/", component);
  }

  updateComponent(component, componentId): Observable<any> {
    return this.api.put("common/v1/components/" + componentId, component);
  }

  deleteComponent(componentId) {
    return this.api
      .delete("common/v1/components/" + componentId)
      .pipe(retry(1), catchError(this.handleError));
  }

  getFilterData(): Observable<any> {
    return this.api.get<{ [key: string]: Data }>("products/v1/products/filters").pipe(
      map((responseData) => {
        return responseData;
      })
    );
  }

  getData(formObject) {
    let searchParams = new HttpParams();
    formObject.graphType = null;
    for (let key in formObject) {
      if (formObject[key] != null) {
        searchParams = searchParams.append(key.toString(), formObject[key]);
      }
    }
    return this.api
      .get<{ [key: string]: Data }>("common/v1/components/search", {
        params: searchParams,
      })
      .pipe(
        map((responseData) => {
          return responseData;
        })
      );
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = "";
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
