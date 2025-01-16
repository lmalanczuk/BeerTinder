import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable} from 'rxjs';

export interface ChatRoom {
  id: number;
  participants: string[];
}

export interface Message {
  id: number;
  chatId: number;
  senderId: number;
  content: string;
  timestamp: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:8080/api/chatrooms';

  constructor(private http: HttpClient) {}

  getChatRoomsForUser(userId: number): Observable<ChatRoom[]> {
    return this.http.get<ChatRoom[]>(`${this.apiUrl}/user/${userId}`);
  }

  getMessages(chatRoomId: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiUrl}/${chatRoomId}/messages`);
  }

  sendMessage(chatRoomId: number, sender: string, content: string): Observable<void> {
    return this.http.post<void>(`http://localhost:8080/api/messages/${chatRoomId}`, {
      sender: sender,
      content: content
    });
  }

  getCurrentUsername(): Observable<string> {
    return this.http.get<{ username: string }>('http://localhost:8080/api/users/current/username')
      .pipe(map(response => response.username));
  }

  getCurrentUserId(): Observable<number> {
    return this.http.get<number>('http://localhost:8080/api/users/current/profile').pipe(
      map((user: any) => user.id) // Zwracamy `id` użytkownika
    );
  }

}
