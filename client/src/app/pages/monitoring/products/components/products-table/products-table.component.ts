import { Component, OnInit, Input, SimpleChanges, EventEmitter, Output } from "@angular/core";
import { ProductSimple } from "../../models/product-simple";
import { MatDialog } from "@angular/material/dialog";

import { animate, state, style, transition, trigger } from "@angular/animations";
import { ProductsWithVersionsData } from "../../models/data.model";
import { ModalLoaderService } from "src/app/shared/components/modal-loader/services/modal-loader.service";
import { PageEvent } from "@angular/material/paginator";
import { Router } from "@angular/router";
import { TableOrderModel } from "src/app/shared/models/table-order.model";

@Component({
  selector: "app-products-table",
  templateUrl: "./products-table.component.html",
  styleUrls: ["./products-table.component.scss"],
  animations: [
    trigger("detailExpand", [
      state("collapsed, void", style({ height: "0px", minHeight: "0", visibility: "hidden" })),
      state("expanded", style({ height: "*", visibility: "visible" })),
      transition("* <=> *", animate("225ms cubic-bezier(0.4, 0.0, 0.2, 1)")),
    ]),
  ],
})
export class ProductsTableComponent implements OnInit {
  @Input() data: ProductsWithVersionsData[];
  @Input() resultsCount: number;
  @Input() gettingData: boolean;
  @Input() nothingHappened: boolean;
  @Input() limit: number;
  @Input() pageIndex: number;
  @Input() productGroups;
  @Output("pageEvent") pageEvent = new EventEmitter<PageEvent>();
  @Output("sortEvent") sortEvent = new EventEmitter<TableOrderModel>();

  columnNames: string[] = [
    "id",
    "Produto",
    "Código",
    "Versão da Especificação",
    "Data da Especificação",
    "Detalhes",
  ];

  columnMap = {
    Produto: "Name",
    Código: "Code",
    "Versão da Especificação": "LastVersion",
    "Data da Especificação": "LastVersionDate",
  };

  dataSource;

  isExpansionDetailRow = (i: number, row: Object) => row.hasOwnProperty("detailRow");
  expandedElement: any;

  displayedColumns: string[] = this.columnNames.slice(1);

  constructor(
    public dialog: MatDialog,
    public modalLoader: ModalLoaderService,
    private router: Router
  ) {}

  openModal(row) {
    let olderVersions = this.dataSource.filter((r) => r.rowPai != undefined && r.rowPai == row.id);
    let group = this.productGroups.filter((g) => g.id == row.groupId);
    row.groupName = group[0].name;
    let versions = {};
    versions["current"] = JSON.stringify(row);
    for (let o = 0; o < olderVersions.length; o++) {
      versions[o.toString()] = JSON.stringify(olderVersions[o].productOlderVersion);
    }
    this.router.navigate(["/monitoring/products/crud"], {
      queryParams: versions,
    });
  }

  ngOnInit(): void {}

  ngOnChanges(changes: SimpleChanges) {
    if (this.limit && changes.limit) {
      this.limit = changes.limit.currentValue;
    }
    if (this.pageIndex && changes.pageIndex) {
      this.pageIndex = changes.pageIndex.currentValue;
    }
    if (this.data && changes.data) {
      if (changes.data.currentValue != changes.data.previousValue) {
        this.dataSource = [];
        const rows = [];
        this.data.forEach(function (productResponse) {
          rows.push({
            productId: productResponse.product.id,
            name: productResponse.product.name,
            code: productResponse.product.code ? productResponse.product.code : " - ",
            specVersion: productResponse.currentVersion.version,
            id: productResponse.currentVersion.id,
            specDate: productResponse.currentVersion.versionDate,
            groupId: productResponse.product.productGroupId,
            groupName: "",
            specDateFormat: new Date(productResponse.currentVersion.versionDate).toLocaleString(),
          });
          if (productResponse.oldVersions) {
            productResponse.oldVersions.forEach(function (olderVersion) {
              //tem que ver se e pelo id do produto ou da especificacao que ele acessa os detalhes
              let productOlderVersion: ProductSimple;
              productOlderVersion = {
                id: olderVersion.id,
                name: productResponse.product.name,
                code: productResponse.product.code ? productResponse.product.code : " - ",
                specVersion: olderVersion.version,
                specDate: olderVersion.versionDate,
                specDateFormat: new Date(olderVersion.versionDate).toLocaleString(),
              };
              rows.push({
                detailRow: true,
                productOlderVersion,
                rowPai: productResponse.currentVersion.id,
              });
            });
          }
        });
        this.dataSource = rows;
      }
    }
  }

  expandRow(e, row) {
    if (e.target.className.__proto__.constructor.name == "SVGAnimatedString") {
      return;
    }
    if (this.expandedElement == row.id) {
      this.expandedElement = null;
    } else {
      this.expandedElement = row.id;
    }
  }

  onPageChange(eventData: PageEvent) {
    this.pageEvent.emit(eventData);
  }

  sortData(eventData: TableOrderModel): void {
    let sortOrder: TableOrderModel = {
      active: this.columnMap[eventData.active],
      direction: eventData.direction,
    };

    this.sortEvent.emit(sortOrder);
  }
}
