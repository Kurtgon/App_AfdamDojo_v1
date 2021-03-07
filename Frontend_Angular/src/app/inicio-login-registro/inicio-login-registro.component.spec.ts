import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioLoginRegistroComponent } from './inicio-login-registro.component';

describe('InicioLoginRegistroComponent', () => {
  let component: InicioLoginRegistroComponent;
  let fixture: ComponentFixture<InicioLoginRegistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioLoginRegistroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioLoginRegistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
