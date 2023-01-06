import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrateUserDialogComponent } from './administrate-user-dialog.component';

describe('AdministrateUserDialogComponent', () => {
  let component: AdministrateUserDialogComponent;
  let fixture: ComponentFixture<AdministrateUserDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministrateUserDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdministrateUserDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
