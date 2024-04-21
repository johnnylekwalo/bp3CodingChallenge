import { Component } from '@angular/core';
import {EdgeService} from "../../services/edge.service";
import {FormsModule} from "@angular/forms";
import { BehaviorSubject } from 'rxjs';
import {NodeModel} from "../../models/node";
import {EdgeModel} from "../../models/edge";
import {NgForOf} from "@angular/common";
import {NodeService} from "../../services/node.service";

@Component({
  selector: 'app-item-create',
  templateUrl: './edge-create.component.html',
  standalone: true,
    imports: [
        FormsModule,
        NgForOf
    ],
  styleUrls: ['./edge-create.component.scss']
})
export class EdgeCreateComponent {
  from: number = 0;
  to: number = 0;
  tos ?: NodeModel[];
  froms ?: NodeModel[];

  constructor(private edgeService: EdgeService ,private nodeService: NodeService ) {
    this.tos = nodeService.getNodes();
    this.froms = nodeService.getNodes();
  }

  onSubmit() {
    const newEdge: EdgeModel= {
      to: this.to,
      from: this.from,
    };

    console.log("newEdge",newEdge)

    this.edgeService.createEdges(newEdge);
  }
}
