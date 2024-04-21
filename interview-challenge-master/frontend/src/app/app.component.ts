import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {EdgeCreateComponent} from "./component/edge-create/edge-create.component";
import {EdgeListComponent} from "./component/edge-list/edge-list.component";
import {NodeListComponent} from "./component/node-list/node-list.component";
import {NodeCreateComponent} from "./component/node-create/node-create.component";
import {HomeComponent} from "./component/layout/home/home.component";
import {NavComponent} from "./component/layout/navbar/nav.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EdgeCreateComponent, EdgeListComponent, NodeListComponent, NodeCreateComponent, HomeComponent, NavComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';
}
