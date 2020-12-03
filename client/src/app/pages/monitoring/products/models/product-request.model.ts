import { PaginatedRequest } from "src/app/shared/models/paginated-request.model";

export class ProductRequest extends PaginatedRequest {
  id: number;
  coordinationId: number;
  productGroupId: number;
  productCode: string;
}
