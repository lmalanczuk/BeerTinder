import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ChatRoom {
  id: number;
  participants: number[];
}

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
  private apiUrl = 'http://localhost:8080/api/chatrooms';

  constructor(private http: HttpClient) {}

  getChatRoomsForUser(userId: number): Observable<ChatRoom[]> {
    return this.http.get<ChatRoom[]>(`${this.apiUrl}/user/${userId}`);
  }

  getMessages(chatRoomId: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiUrl}/${chatRoomId}/messages`);
  }

  sendMessage(chatRoomId: number, text: string): Observable<Message> {
    return this.http.post<Message>(`http://localhost:8080/api/messages/${chatRoomId}`, { text });
  }

}
