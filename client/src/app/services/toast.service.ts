import { Injectable } from "@angular/core";
import { MatSnackBar, MatSnackBarConfig } from "@angular/material/snack-bar";

@Injectable({
  providedIn: "root",
})
export class ToastService {
  backErrorsMessagesDicionary = {
    //Backend Message Variables
    unauthorizedUserAccess: "Usuário não autorizado",
    unauthorizedUserProfileAccess: "Acesso não autorizado ao perfil do usuário",
  };

  frontErrorsMessagesDicionary = {
    // Front End Messages

    invalidPeriod: "Período Inválido",
    selectAtLeastOneVariable: "Selecione pelo menos uma variável",
    selectRegressionMethod: "Selecione o método de regressão",
    selectNormalizationType: "Selecione o tipo de normalização",
  };
  errors = {
    // Back  Errors

    // Authorization error codes 00

    EC0001: this.backErrorsMessagesDicionary.unauthorizedUserAccess,

    EC0002: this.backErrorsMessagesDicionary.unauthorizedUserProfileAccess,
  };

  constructor(private _snackBar: MatSnackBar) {}

  toastrError(error, action: string = "X", variableName: string = "") {
    let config = new MatSnackBarConfig();
    config.verticalPosition = "top";
    config.horizontalPosition = "right";
    config.duration = 0;
    config.panelClass = ["toast-error"];
    let message;
    switch (error.code) {
      case "EC1801":
        this.toastrWarning(error);
        return;
      case "EC1503":
        // When no product attributte is found on coordination, there is no need for error.
        return;
      default:
        message = this.getErrorMessage(error.code, variableName) ?? "Erro desconhecido";
    }
    this._snackBar.open(message, action, config);
  }
  toastrSuccess(message, action: string = "") {
    let config = new MatSnackBarConfig();
    config.verticalPosition = "top";
    config.horizontalPosition = "right";
    config.duration = 5000;
    config.panelClass = ["toast-success"];
    this._snackBar.open(message, action, config);
  }

  toastrWarning(error, action: string = "", variableName: string = "") {
    let config = new MatSnackBarConfig();
    config.verticalPosition = "top";
    config.horizontalPosition = "right";
    config.duration = 3000;
    config.panelClass = ["toast-warning"];
    let message = this.getErrorMessage(error.code, variableName);
    this._snackBar.open(message, action, config);
  }

  getErrorMessage(code, variableName: string = "") {
    if (this.errors[code] != undefined) {
      if (code == "EC1801") {
        return this.errors[code];
      } else if (code == "FE1105") {
        return this.errors[code] + " " + variableName + " (" + code + ")";
      } else {
        return this.errors[code] + " (" + code + ")";
      }
    }
    return null;
  }
}
