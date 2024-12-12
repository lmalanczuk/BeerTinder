import {Component, OnInit} from '@angular/core';
import {CdkDragEnd, DragDropModule} from '@angular/cdk/drag-drop';
import {ButtonModule} from 'primeng/button';
import {CardModule} from 'primeng/card';
import {HttpClient, provideHttpClient} from '@angular/common/http';
import {NgIf} from '@angular/common';
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
  imports: [DragDropModule, ButtonModule, CardModule, NgIf],
  templateUrl: './browse.component.html',
  styleUrl: './browse.component.css'
})
export class BrowseComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) {}

  beers: Beer[] = [];
  currentBeerIndex: number = 0;
  currentUser = {id: 1};

  apiUrl = 'http://localhost:8080/api/beers'; // Adres backendu

  goToHome(): void {
    this.router.navigate(['/']); // Przekierowanie na stronę główną
  }

  ngOnInit(){
    this.fetchBeers();
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

  swipeBeer(direction: string): void {
    const currentBeer = this.beers[this.currentBeerIndex]; // Aktualne piwo

    this.http.post(`${this.apiUrl}/preferences`, {
      beerId: currentBeer.id,
      userId: this.currentUser.id,
      liked: direction === 'like'
    }).subscribe(() => {
      console.log(`${direction === 'like' ? 'Liked' : 'Disliked'}: Beer ID ${currentBeer.id}`);

      // Przejście do kolejnego piwa
      this.currentBeerIndex++;
      if (this.currentBeerIndex >= this.beers.length) {
        console.log('No more beers to display');
        this.currentBeerIndex = 0; // Resetuj indeks, jeśli to konieczne
      }
    });
  }




  /*swipe(direction: string): void {
    if (this.currentBeer) {
      console.log(`Swiped ${direction} on beer: ${this.currentBeer.name}`);
      // Możesz tutaj dodać logikę do przetwarzania lajków/dislajków
      // np. wywołanie odpowiedniej metody backendu.
      // Następnie wybierz następne piwo (jeśli istnieje).
      const currentIndex = this.beers.indexOf(this.currentBeer);
      if (direction === 'like' && currentIndex < this.beers.length - 1) {
        this.currentBeer = this.beers[currentIndex + 1];
      } else if (direction === 'dislike' && currentIndex < this.beers.length - 1) {
        this.currentBeer = this.beers[currentIndex + 1];
      }
    }
  }*/

  likeBeer(): void {
    this.swipeBeer('like'); // Przekaż tylko kierunek
  }

  dislikeBeer(): void {
    this.swipeBeer('dislike'); // Przekaż tylko kierunek
  }


  onDragEnd(event: CdkDragEnd): void {
    const x = event.distance.x;
    if (x > 100) {
      this.likeBeer();
    } else if (x < -100) {
      this.dislikeBeer();
    }
  }

  savePreference(beerId: number, liked: boolean): void {
    const preference = { userId: this.currentUser.id, beerId, liked};
    this.http.post('http://localhost:8080/api/preferences', preference).subscribe(() => {
      console.log(`Preference saved: ${liked ? 'Liked' : 'Disliked'} beer ID ${beerId}`);
    });
  }
}
