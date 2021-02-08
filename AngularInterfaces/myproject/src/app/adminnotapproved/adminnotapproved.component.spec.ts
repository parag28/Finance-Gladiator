import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminnotapprovedComponent } from './adminnotapproved.component';

describe('AdminnotapprovedComponent', () => {
  let component: AdminnotapprovedComponent;
  let fixture: ComponentFixture<AdminnotapprovedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminnotapprovedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminnotapprovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
