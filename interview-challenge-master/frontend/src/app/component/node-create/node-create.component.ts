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

  sharedData: any;
  data: any;

  form: FormGroup;

  types = Object.values(Type);


  constructor(private nodeService: NodeService, private sharedService: SharedService , private fb: FormBuilder) {
    this.sharedService.sharedData$.subscribe(sharedData => this.sharedData = sharedData);
    this.form = this.fb.group({
      newNodeId: ['', Validators.required],
      newNodeType: ['', Validators.required],

    });
  }


  onSubmit() {
    const newEdge: NodeModel= {
      id: this.id,
      name: this.name,
      type: this.type
    };

    console.log("newEdge",newEdge)

    this.nodeService.addNode(newEdge);
  }

  updateData() {
    const newNodeId = this.form.value.newNodeId;
    const newNodeType = this.form.value.newNodeType;
    this.data.newNodeId = newNodeId;
    this.data.newNodeType = newNodeType;
    // this.listItems.push(newItem);
    this.form.reset();
    this.sharedService.setData(this.data);
  }
}
