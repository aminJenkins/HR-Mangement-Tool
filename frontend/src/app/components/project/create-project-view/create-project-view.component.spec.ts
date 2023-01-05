import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProjectViewComponent } from './create-project-view.component';

describe('CreateProjectViewComponent', () => {
  let component: CreateProjectViewComponent;
  let fixture: ComponentFixture<CreateProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
