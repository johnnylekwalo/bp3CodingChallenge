import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdgeListComponent } from './edge-list.component';

describe('EdgeListComponent', () => {
  let component: EdgeListComponent;
  let fixture: ComponentFixture<EdgeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EdgeListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EdgeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
