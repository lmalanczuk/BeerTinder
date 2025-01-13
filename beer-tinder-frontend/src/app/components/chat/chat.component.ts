import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Chat, ChatService} from '../../services/chat.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent implements OnInit {
  userId: number = 1; // Tymczasowo ID użytkownika
  chats: Chat[] = []; // Lista aktywnych czatów

  constructor(private chatService: ChatService, private router: Router) {}

  ngOnInit(): void {
    this.fetchChats();
  }

  // Pobiera listę aktywnych czatów
  fetchChats(): void {
    this.chatService.getUserChats(this.userId).subscribe({
      next: (data) => {
        this.chats = data;
      },
      error: (error) => {
        console.error('Błąd pobierania czatów:', error);
      }
    });
  }

  // Otwiera widok czatu
  openChat(chatId: number): void {
    this.router.navigate(['/chat', chatId]);
  }
}
