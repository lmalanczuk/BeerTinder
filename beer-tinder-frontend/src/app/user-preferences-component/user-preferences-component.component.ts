import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-user-preferences-component',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './user-preferences-component.component.html',
  styleUrl: './user-preferences-component.component.css'
})
export class UserPreferencesComponentComponent {

    preferences: any[] = [];

    constructor(private http: HttpClient) {}

  ngOnInit(): void {
      this.http.get<any[]>('http://localhost:8080/api/preferences/1').subscribe(data => {
        this.preferences = data;
      })
  }
}
