import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentsRegisterComponent } from './components-register.component';

describe('ComponentsRegisterComponent', () => {
  let component: ComponentsRegisterComponent;
  let fixture: ComponentFixture<ComponentsRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentsRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentsRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
