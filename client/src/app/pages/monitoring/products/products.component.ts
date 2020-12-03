import { Component, OnInit } from "@angular/core";
import { FormData } from "./models/form.model";
import { ProductService } from "./services/product.service";
import { ProductRequest } from "./models/product-request.model";
import { PageEvent } from "@angular/material/paginator";

import { TableOrderModel } from "src/app/shared/models/table-order.model";

@Component({
  selector: "app-products",
  templateUrl: "./products.component.html",
  styleUrls: ["./products.component.scss"],
})
export class ProductsComponent implements OnInit {
  gettingData: boolean;
  nothingHappened: boolean;
  searchFilter: ProductRequest;
  productsTableData: any;
  resultsCount: number;
  formData: FormData;
  limit: number = 10;
  sortBy: string = null;
  sortAsc = true;
  pageIndex: number;
  productGroups;

  constructor(private api: ProductService) {}

  setInitialState() {
    this.nothingHappened = true;
    this.gettingData = false;
    this.formData = null;
  }

  ngOnInit(): void {
    this.setInitialState();
  }

  onFormReceived(form: FormData) {
    this.nothingHappened = false;
    this.gettingData = true;
    this.formData = form;
    this.pageIndex = 0;

    this.getProducts();
  }

  onPageChange(eventData: PageEvent): void {
    this.gettingData = true;

    this.limit = eventData.pageSize;
    this.pageIndex = eventData.pageIndex;

    this.getProducts();
  }

  onSortChange(eventData: TableOrderModel): void {
    this.gettingData = true;
    this.pageIndex = 0;

    if (
      eventData.direction === null ||
      eventData.direction === undefined ||
      eventData.direction === ""
    ) {
      this.sortBy = null;
      this.sortAsc = true;
    } else {
      this.sortBy = eventData.active;
      this.sortAsc = eventData.direction === "asc";
    }

    this.getProducts();
  }

  private getProducts() {
    this.productsTableData = [];
    this.resultsCount = 0;

    this.searchFilter = {
      id: this.formData.id,
      coordinationId: this.formData.coordinationId,
      productGroupId: this.formData.productGroupId,
      productCode: this.formData.productCode,
      limit: this.limit,
      offset: this.pageIndex * this.limit,
      sortBy: this.sortBy,
      asc: this.sortAsc,
    };

    this.api.getProducts(this.searchFilter).subscribe(
      (data) => {
        this.productsTableData = data.items;
        this.resultsCount = data.totalCount;
        this.gettingData = false;
      },
      (error) => this.setInitialState()
    );
  }

  onProductGroupsReceived(productGroups) {
    this.productGroups = productGroups;
  }
}
