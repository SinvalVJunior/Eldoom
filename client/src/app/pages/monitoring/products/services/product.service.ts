import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";

import { ProductsWithVersionsData } from "../models/data.model";
import { FormData } from "../models/form.model";
import { Observable } from "rxjs";
import { PaginationResult } from "src/app/shared/models/pagination-result.model";

@Injectable({
  providedIn: "root",
})
export class ProductService {
  constructor(private api: HttpClient) {}

  getProducts(formObject: FormData) {
    let searchParams = new HttpParams();
    for (let key in formObject) {
      if (formObject[key] != null) {
        searchParams = searchParams.append(key.toString(), formObject[key].toString());
      }
    }

    return this.api.get<PaginationResult<ProductsWithVersionsData>>(
      "products/v1/products/versions?",
      {
        params: searchParams,
      }
    );
  }

  getFilters(): Observable<any> {
    return this.api.get<any>("products/v1/products/filters");
  }

  getProductProperties(id) {
    return this.api.get("products/v1/product-versions/{id}/product-properties".replace("{id}", id));
  }
}
