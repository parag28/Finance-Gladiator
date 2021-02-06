import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationpaymentsuccessfulComponent } from './registrationpaymentsuccessful.component';

describe('RegistrationpaymentsuccessfulComponent', () => {
  let component: RegistrationpaymentsuccessfulComponent;
  let fixture: ComponentFixture<RegistrationpaymentsuccessfulComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationpaymentsuccessfulComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationpaymentsuccessfulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
