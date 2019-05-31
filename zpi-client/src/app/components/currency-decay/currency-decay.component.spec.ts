import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentDecayComponent } from './current-decay.component';

describe('CurrentDecayComponent', () => {
  let component: CurrentDecayComponent;
  let fixture: ComponentFixture<CurrentDecayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentDecayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentDecayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
