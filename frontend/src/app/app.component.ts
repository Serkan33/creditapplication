import { Component } from '@angular/core';
import { FormBuilder, Form } from '@angular/forms';
import { CreditserviceService } from './creditservice.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'frontend';
  checkoutForm;
  constructor( private creditService:CreditserviceService,
    private formBuilder:FormBuilder){

      this.checkoutForm = this.formBuilder.group({
        name: '',
        address: ''
      });
  }

  onSubmit(customerData) {
    // Process checkout data here
    this.checkoutForm.reset();
  }
}
