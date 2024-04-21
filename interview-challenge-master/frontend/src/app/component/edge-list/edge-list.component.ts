import { Component, OnInit } from '@angular/core';
import {EdgeService} from "../../services/edge.service";
import {NodeModel} from "../../models/node";
import {NodeService} from "../../services/node.service";
import {EdgeModel} from "../../models/edge";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-item-list',
  templateUrl: './edge-list.component.html',
  standalone: true,
  imports: [
    NgForOf
  ],
  styleUrls: ['./edge-list.component.scss']
})
export class EdgeListComponent {

  edges: EdgeModel[];

  constructor(private edgeService: EdgeService) {
    this.edges = this.edgeService.getEdges();
  }
}
