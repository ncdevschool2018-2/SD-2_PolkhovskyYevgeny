import { TestBed } from '@angular/core/testing';

import { DaysOfWeekService } from './days-of-week.service';

describe('DaysOfWeekService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DaysOfWeekService = TestBed.get(DaysOfWeekService);
    expect(service).toBeTruthy();
  });
});
