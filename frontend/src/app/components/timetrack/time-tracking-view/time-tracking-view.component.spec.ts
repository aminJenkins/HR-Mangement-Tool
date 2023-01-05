import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeTrackingViewComponent } from './time-tracking-view.component';

describe('TimeTrackingViewComponent', () => {
  let component: TimeTrackingViewComponent;
  let fixture: ComponentFixture<TimeTrackingViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimeTrackingViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimeTrackingViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
