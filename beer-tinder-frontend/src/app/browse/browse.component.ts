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

  swipeBeer(beerId: number, direction: string) {
    const swipeUrl = `${this.apiUrl}/swipe`;
    this.http.post(swipeUrl, { beerId, direction }).subscribe(() => {
      console.log(`${direction === 'like' ? 'Liked' : 'Disliked'}: Beer ID ${beerId}`);
      this.currentBeerIndex++;
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

  likeBeer() {
    if (this.currentBeer) {
      this.swipeBeer(this.currentBeer.id, 'like');
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

}
