import {Component, OnInit} from '@angular/core';
import {CdkDragEnd, DragDropModule} from '@angular/cdk/drag-drop';
import {ButtonModule} from 'primeng/button';
import {CardModule} from 'primeng/card';
import {HttpClient, HttpHeaders, provideHttpClient} from '@angular/common/http';
import {NgIf, CommonModule } from '@angular/common';
import {Router} from '@angular/router';


interface Beer {
  id: number;
  name: string,
  description: string,
  imageUrl: string;
}

@Component({
  selector: 'app-browse',
  standalone: true,
  imports: [DragDropModule, ButtonModule, CardModule, NgIf, CommonModule],
  templateUrl: './browse.component.html',
  styleUrl: './browse.component.css'
})
export class BrowseComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) {}

  beers: Beer[] = [];
  currentBeerIndex: number = 0;
  likedBeers: Beer[] = [];

  apiUrl = 'http://localhost:8080/api/beers'; // Adres backendu
  userPreferencesUrl = 'http://localhost:8080/api/preferences/1/liked'; // Zakładając ID użytkownika = 1

  goToHome(): void {
    this.router.navigate(['/']); // Przekierowanie na stronę główną
  }

  ngOnInit(){
    this.fetchBeers();
    this.fetchUserPreferences();
  }

  get currentBeer(): Beer | null {
    return this.currentBeerIndex < this.beers.length
    ? this.beers[this.currentBeerIndex]
      : null;
  }

  fetchBeers() {
    this.http.get<Beer[]>(this.apiUrl).subscribe((data) => {
      this.beers = data;
    });
  }

  fetchUserPreferences() {
    const userId = 1; // Możesz pobrać dynamicznie z systemu logowania
    const preferencesUrl = `http://localhost:8080/api/preferences/${userId}/liked`;

    this.http.get<Beer[]>(preferencesUrl).subscribe((data) => {
      this.likedBeers = data;
    }, error => {
      console.error('Error fetching liked beers:', error);
    });
  }

  swipeBeer(beerId: number, direction: string) {
    const userId = 1; // Pobierz dynamicznie z systemu logowania
    const liked = direction === 'like';

    const swipeUrl = 'http://localhost:8080/api/preferences/add';
    this.http.post(swipeUrl, { userId, beerId, liked }).subscribe(() => {
      console.log(`${liked ? 'Liked' : 'Disliked'}: Beer ID ${beerId}`);

      if (liked && this.currentBeer) {
        // Dodajemy polubione piwo do listy likedBeers
        this.likedBeers.unshift(this.currentBeer);
      }

      this.currentBeerIndex++;
    }, error => {
      console.error('Error swiping beer:', error);
    });
  }



  likeBeer() {
    if (this.currentBeer) {
      console.log('Liking beer:', this.currentBeer);
      this.swipeBeer(this.currentBeer.id, 'like');
    } else {
      console.error('No beer to like');
    }
  }


  dislikeBeer() {
    if (this.currentBeer) {
      this.swipeBeer(this.currentBeer.id, 'dislike');
    }
  }

  onDragEnd(event: CdkDragEnd): void {
    const x = event.distance.x;
    if (x > 100) {
      this.likeBeer();
    } else if (x < -100) {
      this.dislikeBeer();
    }
  }

  removeBeerFromPreferences(beerId: number) {
    const userId = 1; // Pobierz dynamicznie, jeśli masz system logowania

    // Pytanie użytkownika o potwierdzenie
    if (!confirm("Czy na pewno chcesz usunąć to piwo ze swoich ulubionych?")) {
      return;
    }

    const removeUrl = `http://localhost:8080/api/preferences/${userId}/remove/${beerId}`;

    this.http.delete(removeUrl).subscribe({
      next: () => {
        console.log(`Removed beer ID ${beerId} from preferences`);
        this.likedBeers = this.likedBeers.filter(beer => beer.id !== beerId);
      },
      error: (error) => {
        console.error('Error removing beer:', error);
      }
    });
  }
}
