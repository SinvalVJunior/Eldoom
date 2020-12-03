// This class is related to the Data get in the web server.

export class ProductsWithVersionsData {
  currentVersion: Version;
  product: Product;
  oldVersions: Version[];
}

export class Product {
  name: string;
  code: string;
  productGroupId: number;
  coordinationId: number;
  id: number;
}

export class Version {
  version: number;
  versionDate: Date;
  productId: number;
  id: number;
}

export class ComponentNames {
  analysisType: string;
  analysisName: string;
  componentName: string;
  componentOrder: number;
  uom: string;
  lowerLimit: number;
  lowerControl: number;
  objective: number;
  upperControl: number;
  upperLimit: number;
  bulletin: boolean;
  classificatory: boolean;
  productVersionId: number;
  id: number;
}

export class AnalysisName {
  analisysName: string;
  componentNames: ComponentNames[];
}

export class AnalysisType {
  analysisType: string;
  analysisNames: AnalysisName[];
}
