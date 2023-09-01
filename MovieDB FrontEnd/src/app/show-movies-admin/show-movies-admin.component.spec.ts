import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowMoviesAdminComponent } from './show-movies-admin.component';

describe('ShowMoviesAdminComponent', () => {
  let component: ShowMoviesAdminComponent;
  let fixture: ComponentFixture<ShowMoviesAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowMoviesAdminComponent]
    });
    fixture = TestBed.createComponent(ShowMoviesAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
