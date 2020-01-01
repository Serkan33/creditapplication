import { TestBed } from '@angular/core/testing';

import { CreditserviceService } from './creditservice.service';

describe('CreditserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CreditserviceService = TestBed.get(CreditserviceService);
    expect(service).toBeTruthy();
  });
});
