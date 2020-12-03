import { Component, OnInit } from "@angular/core";
import { ApiService } from "./services/api.service";
import { PageEvent } from "@angular/material/paginator";

@Component({
  selector: "app-components-register",
  templateUrl: "./components-register.component.html",
  styleUrls: ["./components-register.component.scss"],
})
export class ComponentsRegisterComponent implements OnInit {
  constructor(private api: ApiService) {}
  newComponent: any = null;
  data: any;
  gettingData: boolean;
  nothingHappened: boolean;
  limit: number;
  pageIndex: number;
  searchFilter: any;
  resultsCount: number;

  ngOnInit(): void {
    this.nothingHappened = true;
    this.gettingData = false;
  }

  async onFormReceived(form) {
    this.gettingData = true;
    this.limit = 10;
    this.pageIndex = 0;
    this.searchFilter = {
      name: form.name,
      coordinationId: form.coordinationId,
      limit: this.limit,
      offset: this.pageIndex,
    };
    let result = await this.getData(this.searchFilter);
    this.data = result.items;
    this.resultsCount = result.totalCount;
    this.gettingData = false;
    this.nothingHappened = false;
  }

  onComponentSaved(newComponent) {
    this.newComponent = newComponent;
  }

  getData(form): Promise<any> {
    return this.api.getData(form).toPromise();
  }

  async onPageChange(eventData: PageEvent) {
    this.gettingData = true;

    this.limit = eventData.pageSize;
    this.pageIndex = eventData.pageIndex;

    this.searchFilter.limit = this.limit;
    this.searchFilter.offset = eventData.pageIndex * eventData.pageSize;

    let result = await this.getData(this.searchFilter);
    this.data = result.items;
    this.resultsCount = result.totalCount;
    this.gettingData = false;
    this.nothingHappened = false;
  }
}
