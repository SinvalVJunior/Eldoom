import { Component, OnInit, ViewEncapsulation, EventEmitter, Output } from "@angular/core";
import { FormData } from "../../models/form.model";
import { ProductService } from "../../services/product.service";
import { MatDialog } from "@angular/material/dialog";

import { ModalLoaderService } from "src/app/shared/components/modal-loader/services/modal-loader.service";

@Component({
  selector: "app-search-bar",
  templateUrl: "./search-bar.component.html",
  styleUrls: ["./search-bar.component.scss"],
  encapsulation: ViewEncapsulation.None,
})
export class SearchBarComponent implements OnInit {
  @Output("formReceived") form = new EventEmitter<FormData>();
  @Output("productGroups") productGroups = new EventEmitter<any>();

  formData: FormData = {
    id: null,
    coordinationId: null,
    productGroupId: null,
    productCode: null,
  };

  coordinations: any[] = [];
  productTypesOptions: any[] = [];
  productOptions: any[] = [];

  productTypes: any[] = [];
  productNames: any[] = [];
  productCodes: string[] = [];

  constructor(
    private api: ProductService,
    public dialog: MatDialog,
    public modalLoader: ModalLoaderService
  ) {
    this.getFilterData();
  }

  getFilterData() {
    this.api.getFilters().subscribe((data: any) => {
      this.coordinations = data.coordinations;
      this.productTypesOptions = data.productTypes;
      this.productOptions = data.products;

      this.productGroups.emit(this.productTypesOptions);
      this.productsFilter();
    });
  }

  ngOnInit(): void {
    this.form.emit(this.formData);
  }

  submitForm() {
    this.form.emit(this.formData);
  }

  clearFilter() {
    this.formData.id = null;
    this.formData.coordinationId = null;
    this.formData.productGroupId = null;
    this.formData.productCode = null;
    this.form.emit(this.formData);
  }

  productsFilter() {
    this.filterProductTypes();
    this.filterProductNames();
    this.filterProductCodes();
  }

  private filterProductTypes() {
    const productTypesIds = this.productOptions.reduce(
      (a, p) => (
        (this.formData.coordinationId === null ||
          this.formData.coordinationId === undefined ||
          p.coordinationId === this.formData.coordinationId) &&
          a.push(p.productGroupId),
        a
      ),
      []
    );

    this.productTypes = this.productTypesOptions.filter((p) => productTypesIds.includes(p.id));

    if (!productTypesIds.includes(this.formData.productGroupId)) {
      this.formData.productGroupId = null;
    }
  }

  private filterProductNames() {
    // this.productNames = this.productOptions.filter(
    //   (p) =>
    //     (this.formData.coordinationId === null ||
    //       this.formData.coordinationId === undefined ||
    //       p.coordinationId === this.formData.coordinationId) &&
    //     (this.formData.productGroupId === null ||
    //       this.formData.productGroupId === undefined ||
    //       p.productGroupId === this.formData.productGroupId)
    // );

    // if (!this.productNames.map(({ id }) => id).includes(this.formData.id)) {
    //   this.formData.id = null;
    // }
  }

  private filterProductCodes() {
    this.productCodes = this.productNames
      .reduce(
        (a, p) => (
          p.productCode !== null &&
            p.productCode !== undefined &&
            p.productCode !== "" &&
            a.push(p.productCode),
          a
        ),
        []
      )
      .sort();

    if (
      !this.productNames.map(({ productCode }) => productCode).includes(this.formData.productCode)
    ) {
      this.formData.productCode = null;
    }
  }
}
