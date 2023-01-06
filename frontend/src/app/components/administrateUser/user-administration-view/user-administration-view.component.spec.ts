import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAdministrationViewComponent } from './user-administration-view.component';

describe('UserAdministrationViewComponent', () => {
  let component: UserAdministrationViewComponent;
  let fixture: ComponentFixture<UserAdministrationViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserAdministrationViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserAdministrationViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
