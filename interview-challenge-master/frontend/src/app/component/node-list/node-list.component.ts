import { Component } from '@angular/core';
import {NodeService} from "../../services/node.service";
import {NodeModel} from "../../models/node";
import {NgForOf} from "@angular/common";
import {SharedService} from "../../services/shared.service";

@Component({
  selector: 'app-node-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './node-list.component.html',
  styleUrl: './node-list.component.scss'
})
export class NodeListComponent {

  nodes: NodeModel[] | undefined;
  sharedData: any;
  data = 'Initial Data';
  constructor(private nodeService: NodeService,private sharedService: SharedService) {
    this.nodes = this.nodeService.getNodes();
    console.log("this.nodes" , this.nodes)
    // this.nodeService.data$.subscribe(data =>
    //   this.nodes = data);
    // this.sharedService.sharedData$
    //   .subscribe((sharedData: string) => {
    //     console.log("sharedData" , sharedData)
    //       this.sharedData = sharedData
    //     }
    //   );
  }

  updateData() {
    this.sharedService.setData(this.data);
  }



}
