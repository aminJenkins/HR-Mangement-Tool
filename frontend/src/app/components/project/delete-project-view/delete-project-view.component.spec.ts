import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteProjectViewComponent } from './delete-project-view.component';

describe('DeleteProjectViewComponent', () => {
  let component: DeleteProjectViewComponent;
  let fixture: ComponentFixture<DeleteProjectViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteProjectViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteProjectViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
