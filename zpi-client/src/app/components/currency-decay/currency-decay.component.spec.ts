import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrencyDecayComponent } from './currency-decay.component';

describe('CurrencyDecayComponent', () => {
  let component: CurrencyDecayComponent;
  let fixture: ComponentFixture<CurrencyDecayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrencyDecayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrencyDecayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
