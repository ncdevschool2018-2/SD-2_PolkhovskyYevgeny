import { TestBed } from '@angular/core/testing';

import { AuthGuardTeacherService } from './auth-guard-teacher.service';

describe('AuthGuardTeacherService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthGuardTeacherService = TestBed.get(AuthGuardTeacherService);
    expect(service).toBeTruthy();
  });
});
