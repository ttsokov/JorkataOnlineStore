import { TestBed, inject } from '@angular/core/testing';

import { ServerAPIService } from './server-api.service';

describe('ServerAPIService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServerAPIService]
    });
  });

  it('should be created', inject([ServerAPIService], (service: ServerAPIService) => {
    expect(service).toBeTruthy();
  }));
});
