import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LastChangesComponent } from './last-changes.component';

describe('LastChangesComponent', () => {
  let component: LastChangesComponent;
  let fixture: ComponentFixture<LastChangesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LastChangesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LastChangesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
