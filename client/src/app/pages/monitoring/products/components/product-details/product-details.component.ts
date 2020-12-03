import { Component, OnInit, ViewChild, ElementRef } from "@angular/core";
import { animate, state, style, transition, trigger } from "@angular/animations";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute, Router } from "@angular/router";
import { from as fromPromise, Observable } from "rxjs";
import { catchError, flatMap } from "rxjs/operators";
import { ProductService } from "../../services/product.service";
import { ToastService } from "src/app/services/toast.service";
import { LastChangesComponent } from "../last-changes/last-changes.component";

@Component({
  selector: "app-product-details",
  templateUrl: "./product-details.component.html",
  styleUrls: ["./product-details.component.scss"],
  animations: [
    trigger("detailExpand", [
      state("collapsed, void", style({ height: "0px", minHeight: "0", display: "none" })),
      state("expanded", style({ height: "*" })),
      transition("expanded => collapsed", animate("225ms cubic-bezier(0.4, 0.0, 0.2, 1)")),
      transition("collapsed => expanded", animate("1ms cubic-bezier(0.4, 0.0, 0.2, 1)")),
      transition("expanded => void", animate("225ms cubic-bezier(0.4, 0.0, 0.2, 1)")),
      transition("void => expanded", animate("1ms cubic-bezier(0.4, 0.0, 0.2, 1)")),
    ]),
  ],
})
export class ProductDetailsComponent implements OnInit {
  isExpansionDetailRow = (i: number, row: Object) => row.hasOwnProperty("detailRow");
  expandedElement = [];
  dataSource = [];
  tabsLoaded: boolean = false;
  tabs = [];
  product: any;

  @ViewChild("pdfTable", { static: false }) pdfTable: ElementRef;

  columnNames: string[] = [
    "id",
    "Exp",
    "Propriedades",
    "Tag",
    "Unid. Med.",
    "LIE",
    "LIC",
    "OBJ",
    "LSC",
    "LSE",
    "Tipo Critério",
    "QPI",
  ];

  displayedColumns: string[] = this.columnNames.slice(1);

  expandedColumnNames: string[] = [
    "expandedId",
    "expandedExp",
    "expandedPropriedades",
    "expandedTag",
    "expandedUnid. Med.",
    "expandedLIE",
    "expandedLIC",
    "expandedOBJ",
    "expandedLSC",
    "expandedLSE",
    "expandedTipo Critério",
    "expandedQPI",
  ];

  propertieName = {
    lowerControl: "LIC",
    lowerLimit: "LIE",
    objective: "OBJ",
    pimsTag: "Tag",
    qpi: "QPI",
    tipoCriterio: "Tipo Critério",
    uom: "Unidade de Medida",
    upperControl: "LSC",
    upperLimit: "LSE",
  };

  expandedDisplayedColumns: string[] = this.expandedColumnNames.slice(1);

  queryParams: any;
  isProductComponent: boolean;
  loadingData: boolean;
  tipoCriterio = [null];
  qpiOptions = [
    { value: null, name: "Todos" },
    { value: true, name: "Verdadeiro" },
    { value: false, name: "Falso" },
  ];
  tipoCriterioFilter: string = null;
  qpiFilter: boolean = null;
  versions = new Array();
  versionId: number;
  data: any;
  modifiedBy: string = null;
  ready: boolean = false;
  allExpanded: boolean = false;
  verifyChanges: boolean = false;
  changes = [];

  constructor(
    public router: Router,
    private route: ActivatedRoute,
    private api: ProductService,
    private toast: ToastService,
    public dialog: MatDialog
  ) {}

  ngOnInit() {
    this.loadingData = true;
    this.route.url.subscribe((urlSections) => {
      if (urlSections[1].path === "products") {
        this.isProductComponent = true;
      }
    });

    fromPromise(this.route.queryParams)
      .pipe(
        flatMap((params) => {
          if (Object.keys(params).length === 0) {
            return new Observable<null>();
          }
          for (var key in params) {
            if (key == "current") {
              this.product = JSON.parse(params[key]);
              this.versions.push({
                id: this.product.id,
                date: this.product.specDate,
                name: this.product.specVersion,
                group: this.product.groupName,
                dateFormat: this.product.specDateFormat,
              });
              this.versionId = this.product.id;
            } else {
              let version = JSON.parse(params[key]);
              this.versions.push({
                id: version.id,
                date: version.specDate,
                name: version.specVersion.toString(),
                dateFormat: version.specDateFormat,
              });
            }
          }
          if (this.isProductComponent) {
            return this.api.getProductProperties(this.product.id);
          }
        }),
        catchError(() => {
          this.loadingData = false;
          return new Observable<null>();
        })
      )
      .subscribe((data) => {
        if (data) {
          this.data = data;
          this.verifyChanges = true;
          this.processTabsData(data);
        } else {
          this.loadingData = false;
          //toastr erro
        }
      });
  }

  processTabsData(input, qpiFilter = null, tipoCriterioFilter = null) {
    let inputData = [];
    this.tabs = [];
    for (let i = 0; i < input.length; i++) {
      for (let j = 0; j < input[i].analysisNames.length; j++) {
        let rowPaiId;
        for (let k = 0; k < input[i].analysisNames[j].componentNames.length; k++) {
          let detailRowData = input[i].analysisNames[j].componentNames[k];
          if (qpiFilter == null && tipoCriterioFilter == null) {
            let repeatedTipoCritério = false;
            for (let i = 0; i < this.tipoCriterio.length; i++) {
              if (this.tipoCriterio[i] == detailRowData.tipoCriterio) {
                repeatedTipoCritério = true;
              }
            }
            if (!repeatedTipoCritério) {
              this.tipoCriterio.push(detailRowData.tipoCriterio);
            }
            if (this.modifiedBy == null && detailRowData.userId != null) {
              this.modifiedBy = detailRowData.userId;
            }
          }
          if (k == 0) {
            if (!this.ready) {
              detailRowData.analysisName += " - " + detailRowData.componentName;
            }
            if (input[i].analysisNames[j].componentNames.length > 1) {
              rowPaiId = detailRowData.id;
              detailRowData.expansible = true;
            }
            if (qpiFilter != null || tipoCriterioFilter != null) {
              if (qpiFilter != null && tipoCriterioFilter != null) {
                if (
                  detailRowData.tipoCriterio == tipoCriterioFilter &&
                  detailRowData.qpi == qpiFilter
                ) {
                  inputData.push(detailRowData);
                }
              } else {
                if (qpiFilter != null) {
                  if (detailRowData.qpi == qpiFilter) {
                    inputData.push(detailRowData);
                  }
                } else {
                  if (detailRowData.tipoCriterio == tipoCriterioFilter) {
                    inputData.push(detailRowData);
                  }
                }
              }
            } else {
              inputData.push(detailRowData);
            }
          } else {
            if (qpiFilter != null || tipoCriterioFilter != null) {
              if (qpiFilter != null && tipoCriterioFilter != null) {
                if (
                  detailRowData.tipoCriterio == tipoCriterioFilter &&
                  detailRowData.qpi == qpiFilter
                ) {
                  inputData.push({ detailRow: true, detailRowData, rowPai: rowPaiId });
                }
              } else {
                if (qpiFilter != null) {
                  if (detailRowData.qpi == qpiFilter) {
                    inputData.push({ detailRow: true, detailRowData, rowPai: rowPaiId });
                  }
                } else {
                  if (detailRowData.tipoCriterio == tipoCriterioFilter) {
                    inputData.push({ detailRow: true, detailRowData, rowPai: rowPaiId });
                  }
                }
              }
            } else {
              inputData.push({ detailRow: true, detailRowData, rowPai: rowPaiId });
            }
          }
        }
      }
      this.tabs.push({ analysisType: input[i].analysisType, data: inputData });
      inputData = [];
    }
    if (this.verifyChanges) {
      this.lastChanges();
      this.verifyChanges = false;
    }
    this.loadingData = false;
    this.tabsLoaded = true;
    this.ready = true;
  }

  expandRow(rowId) {
    if (this.expandedElement.includes(rowId)) {
      let index = this.expandedElement.indexOf(rowId);
      this.expandedElement.splice(index, 1);
    } else {
      this.expandedElement.push(rowId);
    }
  }

  changeTab() {
    this.expandedElement = [];
    this.allExpanded = false;
  }

  expandAll(rows) {
    if (this.allExpanded) {
      this.expandedElement = [];
      this.allExpanded = false;
      return;
    }
    this.allExpanded = true;
    this.expandedElement = [];
    for (let i = 0; i < rows.length; i++) {
      if (rows[i].expansible) {
        this.expandedElement.push(rows[i].id);
      }
    }
  }

  pdfExport() {
    try {

      this.toast.toastrSuccess("PDF exportado com sucesso!", "X");
    } catch (e) {
      this.toast.toastrError("FE2101", "X");
    }
  }

  async changeVersion(event) {
    this.versionId = event.value;
    this.loadingData = true;
    this.api.getProductProperties(this.versionId).subscribe((data) => {
      if (data) {
        this.data = data;
        this.ready = false;
        this.qpiFilter = null;
        this.tipoCriterioFilter = null;
        this.expandedElement = [];
        this.verifyChanges = true;
        this.processTabsData(data, this.qpiFilter, this.tipoCriterioFilter);
      }
    });
  }

  filter() {
    this.processTabsData(this.data, this.qpiFilter, this.tipoCriterioFilter);
  }

  clearFilter() {
    this.qpiFilter = null;
    this.tipoCriterioFilter = null;
    this.filter();
  }

  countProperties(tab) {
    return tab.data.filter((d) => d.componentOrder == 1).length;
  }

  verifyVersion() {
    let thisVersion = this.versions.filter((v) => v.id == this.versionId);
    let version = this.versions.filter((v) => new Date(v.date) > new Date(thisVersion[0].date));
    if (version.length > 0) {
      return false;
    } else {
      return true;
    }
  }

  async lastChanges() {
    let version = this.versions.filter((v) => v.id == this.versionId);
    let olderVersions = this.versions.filter(
      (v) => v.id != this.versionId && new Date(v.date) < new Date(version[0].date)
    );
    let lastVersion = null;
    for (let i = 0; i < olderVersions.length; i++) {
      if (lastVersion) {
        if (new Date(lastVersion.date) < new Date(olderVersions[i].date)) {
          lastVersion = olderVersions[i];
        }
      } else {
        lastVersion = olderVersions[i];
      }
    }
    if (!lastVersion) {
      this.changes = [];
      return;
    }
    try {
      let data = await this.getProductProperties(lastVersion.id);
      if (data) {
        this.changes = [];
        for (let i = 0; i < data.length; i++) {
          let addedProperties = [];
          let removedProperties = [];
          let addedComponents = [];
          let removedComponents = [];
          let modifiedProperties = [];
          let filtered = this.data.filter((d) => d.analysisType == data[i].analysisType);
          for (let j = 0; j < filtered[0].analysisNames.length; j++) {
            let filteredAnalysis = data[i].analysisNames.filter(
              (d) => d.analisysName == filtered[0].analysisNames[j].analisysName
            );
            if (filteredAnalysis.length == 0) {
              addedProperties.push(filtered[0].analysisNames[j].analisysName);
            } else {
              for (let l = 0; l < filtered[0].analysisNames[j].componentNames.length; l++) {
                let filteredComponents = filteredAnalysis[0].componentNames.filter(
                  (c) =>
                    c.componentName == filtered[0].analysisNames[j].componentNames[l].componentName
                );
                if (filteredComponents.length == 0) {
                  addedComponents.push(
                    filtered[0].analysisNames[j].analisysName +
                      " - " +
                      filtered[0].analysisNames[j].componentNames[l].componentName
                  );
                } else {
                  for (var property in filteredComponents[0]) {
                    if (
                      filteredComponents[0][property] !=
                        filtered[0].analysisNames[j].componentNames[l][property] &&
                      property != "analysisName" &&
                      property != "userId" &&
                      property != "productVersionId" &&
                      property != "id" &&
                      property != "pimsId" &&
                      property != "componentOrder" &&
                      property != "componentName" &&
                      property != "bulletin"
                    ) {
                      modifiedProperties.push(
                        filteredComponents[0].analysisName +
                          " - " +
                          filteredComponents[0].componentName +
                          " | " +
                          this.propertieName[property] +
                          " Valor Antigo: " +
                          filteredComponents[0][property] +
                          " Valor Atual: " +
                          filtered[0].analysisNames[j].componentNames[l][property]
                      );
                    }
                  }
                }
              }
              for (let m = 0; m < filteredAnalysis[0].componentNames.length; m++) {
                let filteredComponents = filtered[0].analysisNames[j].componentNames.filter(
                  (c) => c.componentName == filteredAnalysis[0].componentNames[m].componentName
                );
                if (filteredComponents.length == 0) {
                  removedComponents.push(
                    filteredAnalysis[0].analisysName +
                      " - " +
                      filteredAnalysis[0].componentNames[m].componentName
                  );
                }
              }
            }
          }
          for (let k = 0; k < data[i].analysisNames.length; k++) {
            let filteredAnalysis = filtered[0].analysisNames.filter(
              (d) => d.analisysName == data[i].analysisNames[k].analisysName
            );
            if (filteredAnalysis.length == 0) {
              removedProperties.push(data[i].analysisNames[k].analisysName);
            }
          }
          this.changes.push({
            name: data[i].analysisType,
            addedProperties: addedProperties,
            removedProperties: removedProperties,
            addedComponents: addedComponents,
            removedComponents: removedComponents,
            modifiedProperties: modifiedProperties,
          });
        }
      }
    } catch (e) {}
  }

  getProductProperties(id): Promise<any> {
    return this.api.getProductProperties(id).toPromise();
  }

  openDialog() {
    let dialogRef;
    dialogRef = this.dialog.open(LastChangesComponent, {
      disableClose: true,
      data: {
        changes: this.changes,
      },
    });

    dialogRef.afterClosed().subscribe(() => {});
  }
}
