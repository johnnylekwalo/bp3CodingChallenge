import { Component, OnInit } from '@angular/core';

import {NgForOf} from "@angular/common";
import {EdgeCreateComponent} from "../../edge-create/edge-create.component";
import {EdgeListComponent} from "../../edge-list/edge-list.component";
import {NodeCreateComponent} from "../../node-create/node-create.component";
import {NodeListComponent} from "../../node-list/node-list.component";
import {EdgeService} from "../../../services/edge.service";
import {ProcessService} from "../../../services/process.service";
import {ProcessDiagram} from "../../../models/processDiagram";
import {NodeService} from "../../../services/node.service";
import {FormsModule} from "@angular/forms";
import {EdgeModel} from "../../../models/edge";
import {NodeModel} from "../../../models/node";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone: true,
  imports: [
    NgForOf,
    EdgeCreateComponent,
    EdgeListComponent,
    NodeCreateComponent,
    NodeListComponent,
    FormsModule
  ],
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  resultProcessDiagram?: ProcessDiagram[];

  resultEdgeModel?: EdgeModel[];

  resultNodeModel?: NodeModel[];
  constructor(private processService: ProcessService,
              private edgeService: EdgeService,
              private nodeService: NodeService
              ) {
  }

  onSubmit(){
    let processDiagram = new ProcessDiagram();
    processDiagram.edges = this.edgeService.getEdges();
    processDiagram.nodes = this.nodeService.getNodes();
    this.processService.postData(processDiagram).subscribe((data: any) => {
      console.log("data", data);
      this.resultProcessDiagram = data;
      this.resultEdgeModel = data.edges;
      this.resultNodeModel = data.nodes;
    });

  }




}
