import { Component } from '@angular/core';
import {EdgeService} from "../../services/edge.service";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {NodeService} from "../../services/node.service";
import {NodeModel} from "../../models/node";
import {SharedService} from "../../services/shared.service";
import { Type } from '../../models/type';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-node-create',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf
  ],
  templateUrl: './node-create.component.html',
  styleUrl: './node-create.component.scss'
})
export class NodeCreateComponent {
  id: number = 0;
  name: string = '';
  type: string = '';

  data: any;

  types = Object.values(Type);

  constructor(private nodeService: NodeService, private sharedService: SharedService , private fb: FormBuilder) {

  }


  onSubmit() {
    const newEdge: NodeModel= {
      id: this.id,
      name: this.name,
      type: this.type
    };
    this.nodeService.addNode(newEdge);
    this.clearFrom();
  }

  clearFrom(){
      this.id = 0;
      this.name = '';
      this.type = '';
  }


}
