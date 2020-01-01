import { AbstractControl, FormGroup } from '@angular/forms';


export function citizenValidador(control: AbstractControl) {

  if (control && (control.value !== null || control.value !== undefined)) {
    const regex = new RegExp('^[1-9]{11}$');

    if (!regex.test(control.value)) {
      return {
        isError: true
      };
    }
  }

  return null;
}

export function phoneValidator(control: AbstractControl) {

  if (control && (control.value !== null || control.value !== undefined)) {
    const regex = new RegExp('^(05)([0-9]{9})$');

    if (!regex.test(control.value)) {
      return {
        isError: true
      };
    }
  }

  return null;
}



