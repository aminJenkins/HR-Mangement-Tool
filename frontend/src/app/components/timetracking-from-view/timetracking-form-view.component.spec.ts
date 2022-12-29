import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimetrackingFormViewComponent } from './timetracking-form-view.component';

describe('TimetrackingFromViewComponent', () => {
  let component: TimetrackingFormViewComponent;
  let fixture: ComponentFixture<TimetrackingFormViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimetrackingFormViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimetrackingFormViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
