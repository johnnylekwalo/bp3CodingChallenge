import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {NodeModel} from "../models/node";
import {EdgeModel} from "../models/edge";

@Injectable({
  providedIn: 'root'
})
export class EdgeService {
  edges: EdgeModel[] = [];

  getEdges() {
    return this.edges;
  }

  createEdges(edge:EdgeModel){
    this.edges.push(edge)
  }
}

