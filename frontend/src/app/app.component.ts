import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CreditserviceService} from './creditservice.service';
import {citizenValidador, phoneValidator} from './validator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'frontend';
  checkoutForm: FormGroup;
  items: boolean;
  message: string;

  constructor(private creditService: CreditserviceService,
              private formBuilder: FormBuilder) {
    this.checkoutForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', [Validators.required, Validators.minLength(3)]],
      citizenNumber: ['', citizenValidador],
      monthlyIncome: [0, [Validators.required, Validators.min(1)]],
      phone: ['', [phoneValidator, Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
    });
  }

  onSubmit(customerData) {
    // Process checkout data here
    console.log(customerData);
    this.creditService.creditLoan(customerData).subscribe(
      value => {
        console.log(value);
        if (value['status']) {
          console.log(value);
          this.items = true;
        } else {
          this.items = false;
        }
        this.message = value['message'];
      }, error => {
        this.items = false;
        this.message = error.error.message;
      }
    );
  }
}
