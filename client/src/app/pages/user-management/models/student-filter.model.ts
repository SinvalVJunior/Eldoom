import { PaginatedRequest } from "src/app/shared/models/paginated-request.model";

export class StudentFilter extends PaginatedRequest {
  name?: string;
  registrationCode?: number;
  registrationDateRange?: [Date, Date];

  constructor(obj: Partial<StudentFilter>) {
    super();
    for (const prop of Object.keys(obj)) {
      this[prop] = obj[prop];
    }
  }
}
