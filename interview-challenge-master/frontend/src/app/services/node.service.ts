import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import { catchError } from 'rxjs/operators';
import {NodeModel} from "../models/node";

@Injectable({
  providedIn: 'root'
})
export class NodeService {
  // private apiUrl = 'http://localhost:3000/items'; // Assuming the API endpoint for items
  nodes: NodeModel[] = [];
  // private dataSubject = new BehaviorSubject<NodeModel[]>([]);
  // public data$ = this.dataSubject.asObservable();

  constructor(private http: HttpClient) { }

  getNodes() {
    return this.nodes;
  }

  // createNode(node: NodeModel){
  //   this.nodes.push(node);
  //   console.log("node",node);
  //   this.dataSubject.next(this.nodes);
  // }
  addNode(node : NodeModel) {
    this.nodes.push(node);
  }

}
