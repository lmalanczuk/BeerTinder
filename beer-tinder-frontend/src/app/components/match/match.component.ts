import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Match, MatchService} from '../../services/match.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-match',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './match.component.html',
  styleUrl: './match.component.css'
})
export class MatchComponent implements OnInit {
  userId: number = 1; // Tymczasowo ID użytkownika
  matches: Match[] = []; // Lista dopasowań

  constructor(private matchService: MatchService, private router: Router) {}

  ngOnInit(): void {
    this.fetchMatches();
  }

  // Pobiera listę dopasowań
  fetchMatches(): void {
    this.matchService.getUserMatches(this.userId).subscribe({
      next: (data) => {
        this.matches = data;
      },
      error: (error) => {
        console.error('Błąd pobierania dopasowań:', error);
      }
    });
  }

  // Rozpoczęcie czatu → Przekierowanie do widoku czatu z danym użytkownikiem
  startChat(targetUserId: number): void {
    this.router.navigate(['/chat', targetUserId]);
  }
}
