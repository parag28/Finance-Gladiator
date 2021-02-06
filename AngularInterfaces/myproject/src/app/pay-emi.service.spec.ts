import { TestBed } from '@angular/core/testing';

import { PayEMIService } from './pay-emi.service';

describe('PayEMIService', () => {
  let service: PayEMIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayEMIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
