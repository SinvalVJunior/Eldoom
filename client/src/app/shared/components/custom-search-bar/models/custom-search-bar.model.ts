export class CustomSearchBarDefinition {
  fields: SearchField[];
  searchButtonHidden?: boolean;
  searchButtonTooltip?: string;
  clearButtonHidden?: boolean;
  clearButtonTooltip?: string;

  constructor(obj: Partial<CustomSearchBarDefinition>) {
    for (const prop of Object.keys(obj)) {
      this[prop] = obj[prop];
    }
  }
}

export interface SearchField {
  name: string;
  defaultValue?: any;
  filterName?: string;
  filterValue?: (obj: any) => any;
  type?: FieldType;
  options?: any[];
  optionsDisplayName?: (obj: any) => any;
}

export const enum FieldType {
  TEXT = 0,
  SELECT,
  MULT_SELECT,
  TEXT_AUTO_COMPLETE,
  DATE_RANGE
}
