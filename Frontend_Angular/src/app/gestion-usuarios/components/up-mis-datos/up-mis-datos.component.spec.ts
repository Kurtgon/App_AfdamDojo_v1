import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpMisDatosComponent } from './up-mis-datos.component';

describe('UpMisDatosComponent', () => {
  let component: UpMisDatosComponent;
  let fixture: ComponentFixture<UpMisDatosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpMisDatosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpMisDatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
