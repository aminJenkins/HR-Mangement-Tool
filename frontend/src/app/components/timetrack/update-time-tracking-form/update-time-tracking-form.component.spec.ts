import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTimeTrackingFormComponent } from './update-time-tracking-form.component';

describe('UpdateTimeTrackingFormComponent', () => {
  let component: UpdateTimeTrackingFormComponent;
  let fixture: ComponentFixture<UpdateTimeTrackingFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTimeTrackingFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateTimeTrackingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
