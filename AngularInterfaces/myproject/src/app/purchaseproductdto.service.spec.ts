import { TestBed } from '@angular/core/testing';

import { PurchaseproductdtoService } from './purchaseproductdto.service';

describe('PurchaseproductdtoService', () => {
  let service: PurchaseproductdtoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PurchaseproductdtoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
