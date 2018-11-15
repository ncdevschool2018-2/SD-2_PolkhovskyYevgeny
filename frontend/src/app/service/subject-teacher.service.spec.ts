import { TestBed } from '@angular/core/testing';

import { SubjectTeacherService } from './subject-teacher.service';

describe('SubjectTeacherService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SubjectTeacherService = TestBed.get(SubjectTeacherService);
    expect(service).toBeTruthy();
  });
});
