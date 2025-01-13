import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SwipeService {
  private apiUrl = 'http://localhost:8080/api/swipe'; // Adres backendu

  constructor(private http: HttpClient) {}

  // Wysyłanie swipe (Like/Dislike)
  swipeUser(userId: number, targetUserId: number, liked: boolean): Observable<any> {
    const params = new URLSearchParams();
    params.append('userId', userId.toString());
    params.append('targetUserId', targetUserId.toString());
    params.append('liked', liked.toString());

    return this.http.post<any>(`${this.apiUrl}?${params.toString()}`, {});
  }
}
