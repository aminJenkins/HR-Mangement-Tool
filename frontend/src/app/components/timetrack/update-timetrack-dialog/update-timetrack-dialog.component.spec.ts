import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTimetrackDialogComponent } from './update-timetrack-dialog.component';

describe('UpdateTimetrackDialogComponent', () => {
  let component: UpdateTimetrackDialogComponent;
  let fixture: ComponentFixture<UpdateTimetrackDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTimetrackDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateTimetrackDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
