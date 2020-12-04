import { PaginatedRequest } from "src/app/shared/models/paginated-request.model";

export class AClassFilter extends PaginatedRequest {
  codigo?: string;
  professorNome?: string;
  disciplinaNome?: string;

  constructor(obj: Partial<AClassFilter>) {
    super();
    for (const prop of Object.keys(obj)) {
      this[prop] = obj[prop];
    }
  }
}
