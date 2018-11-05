import { TestBed } from '@angular/core/testing';

import { GroupContentService } from './group-content.service';

describe('GroupContentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GroupContentService = TestBed.get(GroupContentService);
    expect(service).toBeTruthy();
  });
});
