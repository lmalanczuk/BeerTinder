import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Interfejs dla czatu
export interface Chat {
  id: number;
  partnerId: number;
  partnerName: string;
}

// Interfejs dla wiadomości w czacie
export interface Message {
  id: number;
  chatId: number;
  senderId: number;
  text: string;
  timestamp: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:8080/api/chat'; // Adres backendu

  constructor(private http: HttpClient) {}

  // Pobieranie listy czatów użytkownika
  getUserChats(userId: number): Observable<Chat[]> {
    return this.http.get<Chat[]>(`${this.apiUrl}/user/${userId}`);
  }

  // Pobieranie wiadomości w czacie
  getMessages(chatId: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiUrl}/${chatId}/messages`);
  }

  // Wysyłanie wiadomości do czatu
  sendMessage(chatId: number, text: string): Observable<Message> {
    return this.http.post<Message>(`${this.apiUrl}/${chatId}/messages`, { text });
  }

  // Tworzenie nowego czatu (jeśli nie istnieje)
  createChat(userId: number, targetUserId: number): Observable<Chat> {
    return this.http.post<Chat>(`${this.apiUrl}/create`, { userId, targetUserId });
  }
}
