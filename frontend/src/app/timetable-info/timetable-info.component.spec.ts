import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TimetableInfoComponent} from './timetable-info.component';

describe('TimetableInfoComponent', () => {
  let component: TimetableInfoComponent;
  let fixture: ComponentFixture<TimetableInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TimetableInfoComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimetableInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
