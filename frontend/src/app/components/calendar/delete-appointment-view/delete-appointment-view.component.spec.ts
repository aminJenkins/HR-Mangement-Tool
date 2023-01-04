import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteAppointmentViewComponent } from './delete-appointment-view.component';

describe('DeleteAppointmentViewComponent', () => {
  let component: DeleteAppointmentViewComponent;
  let fixture: ComponentFixture<DeleteAppointmentViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteAppointmentViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteAppointmentViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
