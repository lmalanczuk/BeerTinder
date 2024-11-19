import { Component } from '@angular/core';
import { ButtonModule} from 'primeng/button';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ButtonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent { }
