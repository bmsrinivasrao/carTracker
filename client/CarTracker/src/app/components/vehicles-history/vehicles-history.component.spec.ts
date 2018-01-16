import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiclesHistoryComponent } from './vehicles-history.component';

describe('VehiclesHistoryComponent', () => {
  let component: VehiclesHistoryComponent;
  let fixture: ComponentFixture<VehiclesHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehiclesHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehiclesHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
