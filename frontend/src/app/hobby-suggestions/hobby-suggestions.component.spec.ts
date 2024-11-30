import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HobbySuggestionsComponent } from './hobby-suggestions.component';

describe('HobbySuggestionsComponent', () => {
  let component: HobbySuggestionsComponent;
  let fixture: ComponentFixture<HobbySuggestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HobbySuggestionsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HobbySuggestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
