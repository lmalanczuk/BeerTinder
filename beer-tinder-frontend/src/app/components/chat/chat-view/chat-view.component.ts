import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChatService, ChatRoom } from '../../../services/chat.service';
import {CommonModule} from '@angular/common';
import {Button, ButtonDirective} from 'primeng/button';

@Component({
  selector: 'app-chat-view',
  standalone: true,
  imports: [CommonModule, Button, ButtonDirective],
  templateUrl: './chat-view.component.html',
  styleUrls: ['./chat-view.component.css']
})
export class ChatViewComponent implements OnInit {
  userId: number = 1; // Tymczasowe ID użytkownika
  chatRooms: ChatRoom[] = [];

  constructor(private chatService: ChatService, private router: Router) {}

  ngOnInit(): void {
    this.fetchChatRooms();
  }

  fetchChatRooms(): void {
    this.chatService.getChatRoomsForUser(this.userId).subscribe({
      next: (data: ChatRoom[]) => {
        this.chatRooms = data;
      },
      error: (error: any) => {
        console.error('Błąd pobierania czatów:', error);
      }
    });
  }

  openChat(chatRoomId: number): void {
    this.router.navigate(['/chat', chatRoomId]);
  }

  goToHome(): void {
    this.router.navigate(['/']); // Przekierowanie na stronę główną
  }
}
