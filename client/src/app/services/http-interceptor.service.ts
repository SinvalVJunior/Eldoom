import { Injectable } from "@angular/core";
import {
  HttpInterceptor,
  HttpHandler,
  HttpEvent,
  HttpRequest,
  HttpResponse,
  HttpErrorResponse,
} from "@angular/common/http";

import { environment } from "./../../environments/environment";

import { Observable, of, throwError } from "rxjs";
import { tap, catchError } from "rxjs/operators";

import { ToastService } from "src/app/services/toast.service";

@Injectable({
  providedIn: "root",
})
export class HttpInterceptorService implements HttpInterceptor {
  // private functions
  private b64EncodeUnicode(str) {
    return btoa(
      encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, (match, p1) => {
        return String.fromCharCode(parseInt(p1, 16));
      })
    );
  }

  constructor(protected toast: ToastService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let urlCodeChanger: string;
    if (req.url !== "") {
      urlCodeChanger = req.url[0];
    }

    if (urlCodeChanger === "@") {
      return next.handle(req.clone({ url: req.url.substr(1) }));
    }

    if (urlCodeChanger === "#" || urlCodeChanger !== "/") {
      const noChangeReq = req.clone({ url: req.url.substr(1) });
      return next.handle(noChangeReq).pipe(
        tap((evt) => {
          if (evt instanceof HttpResponse) {
            // if (evt.body && evt.body.success) this.toast.toastrSuccess("Sucesso");
          }
        }),
        catchError((err: any) => {
          if (err instanceof HttpErrorResponse) {
            try {
              this.toast.toastrError(err.error, "X");
            } catch (e) {
              this.toast.toastrError({ code: "An error occurred" });
            }
          }
          return of(err);
        })
      );
    }
    const baseUrl =
      environment.eldoomApiEndpoint.slice(-1) === "/"
        ? environment.eldoomApiEndpoint.slice(0, -1)
        : environment.eldoomApiEndpoint;

    console.log(baseUrl, environment.eldoomApiEndpoint);

    const apiReq = req.clone({ url: `${baseUrl}${req.url}` });

    return next.handle(apiReq).pipe(
      tap((evt) => {
        if (evt instanceof HttpResponse) {
          // if (evt.body && evt.body.success) this.toast.toastrSuccess("Sucesso");
        }
      }),
      catchError((err: any) => {
        if (err instanceof HttpErrorResponse) {
          try {
            const errorMsg = err.error ?? err.message;
            this.toast.toastrError(errorMsg, "X");
          } catch (e) {
            this.toast.toastrError({ code: "An error occurred" });
          }
        }
        return throwError(err);
      })
    );
  }
}
