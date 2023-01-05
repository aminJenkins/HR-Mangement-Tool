import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProjectViewComponent } from './update-project-view.component';

describe('UpdateProjectViewComponent', () => {
  let component: UpdateProjectViewComponent;
  let fixture: ComponentFixture<UpdateProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
