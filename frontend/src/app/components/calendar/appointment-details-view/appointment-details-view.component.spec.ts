import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentDetailsViewComponent } from './appointment-details-view.component';

describe('AppointmentDetailsViewComponent', () => {
  let component: AppointmentDetailsViewComponent;
  let fixture: ComponentFixture<AppointmentDetailsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentDetailsViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
