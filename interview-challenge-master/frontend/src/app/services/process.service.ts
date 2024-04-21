import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {NodeModel} from "../models/node";
import {EdgeModel} from "../models/edge";

@Injectable({
  providedIn: 'root'
})
export class ProcessService {


  constructor(private http: HttpClient) {

  }

  postData(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/reduce', data);
  }

}

