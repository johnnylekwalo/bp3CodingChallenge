import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import {NodeModel} from "../models/node";
import { Subject, Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  private sharedData: Subject<any> = new Subject<any>();
  sharedData$: Observable<any> = this.sharedData.asObservable();

  constructor() { }

  setData(updatedData: any) {
    this.sharedData.next(updatedData);
  }

}
