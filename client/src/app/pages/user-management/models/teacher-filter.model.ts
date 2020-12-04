import { PaginatedRequest } from "src/app/shared/models/paginated-request.model";

export class TeacherFilter extends PaginatedRequest {
  name?: string;

  constructor(obj: Partial<TeacherFilter>) {
    super();
    for (const prop of Object.keys(obj)) {
      this[prop] = obj[prop];
    }
  }
}
