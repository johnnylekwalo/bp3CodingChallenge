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
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  standalone: true,
  imports: [
    NgForOf,
    EdgeCreateComponent,
    EdgeListComponent,
    NodeCreateComponent,
    NodeListComponent,
    FormsModule
  ],
  styleUrls: ['./nav.component.scss']
})
export class NavComponent {

}
