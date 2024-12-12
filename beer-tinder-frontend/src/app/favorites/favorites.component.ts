import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CardModule} from 'primeng/card';

@Component({
  selector: 'app-favorites',
  standalone: true,
  imports: [
    CardModule
  ],
  templateUrl: './favorites.component.html',
  styleUrl: './favorites.component.css'
})
export class FavoritesComponent {
  likedBeers: any[] = [];
  currentUserId: number = 1; // Zakładamy, że ID użytkownika to 1 (do dynamicznej obsługi dodać logowanie)

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getLikedBeers();
  }

  getLikedBeers(): void {
    this.http.get<any[]>(`http://localhost:8080/api/preferences/liked/${this.currentUserId}`)
      .subscribe(data => {
        this.likedBeers = data;
        console.log('Liked beers:', this.likedBeers);
      });
  }
}
