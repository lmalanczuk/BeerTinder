import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPreferencesComponentComponent } from './user-preferences-component.component';

describe('UserPreferencesComponentComponent', () => {
  let component: UserPreferencesComponentComponent;
  let fixture: ComponentFixture<UserPreferencesComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserPreferencesComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserPreferencesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
