import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TimetableInfoTeacherComponent} from './timetable-info-teacher.component';

describe('TimetableInfoTeacherComponent', () => {
  let component: TimetableInfoTeacherComponent;
  let fixture: ComponentFixture<TimetableInfoTeacherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TimetableInfoTeacherComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimetableInfoTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
