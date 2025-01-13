import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interfejs dla pojedynczego dopasowania
export interface Match {
  id: number;
  matchedAt: string;
  user1Name: string;
  user2Name: string;
  user2Id: number; // Dodane do przekierowania do czatu
}

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private apiUrl = 'http://localhost:8080/api/matches'; // Adres backendu

  constructor(private http: HttpClient) {}

  // Pobieranie listy dopasowań dla użytkownika
  getUserMatches(userId: number): Observable<Match[]> {
    return this.http.get<Match[]>(`${this.apiUrl}/${userId}`);
  }
}
