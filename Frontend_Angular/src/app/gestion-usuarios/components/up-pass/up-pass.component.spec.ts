import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpPassComponent } from './up-pass.component';

describe('UpPassComponent', () => {
  let component: UpPassComponent;
  let fixture: ComponentFixture<UpPassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpPassComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
