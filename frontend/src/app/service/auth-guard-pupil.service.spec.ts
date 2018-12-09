import { TestBed } from '@angular/core/testing';

import { AuthGuardPupilService } from './auth-guard-pupil.service';

describe('AuthGuardPupilService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthGuardPupilService = TestBed.get(AuthGuardPupilService);
    expect(service).toBeTruthy();
  });
});
