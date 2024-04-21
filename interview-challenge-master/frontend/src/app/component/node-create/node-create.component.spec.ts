import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NodeCreateComponent } from './node-create.component';

describe('NodeCreateComponent', () => {
  let component: NodeCreateComponent;
  let fixture: ComponentFixture<NodeCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NodeCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NodeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
