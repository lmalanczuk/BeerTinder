import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { ChatService, Message } from '../../services/chat.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {Button, ButtonDirective} from 'primeng/button';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [CommonModule, FormsModule, Button, ButtonDirective],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  chatRoomId!: number;
  messages: Message[] = [];
  newMessage: string = '';
  receiverUsername: string | null = null;
  currentUserId: number = 1; // Mockowane ID użytkownika, np. 1


  constructor(private route: ActivatedRoute, private chatService: ChatService, private router: Router) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.chatRoomId = +params['chatRoomId'];
      this.loadMessages();

      setInterval(() => this.loadMessages(), 5000); // 🔄 Automatyczne odświeżanie co 5 sek.
    });
  }


  loadMessages(): void {
    this.chatService.getMessages(this.chatRoomId).subscribe(messages => {
      console.log("Wiadomości w chat.component.ts:", messages);
      this.messages = messages;
    });
  }




  sendMessage(): void {
    if (!this.newMessage.trim()) return;

    this.chatService.getCurrentUsername().subscribe((username: string) => {
      this.chatService.sendMessage(this.chatRoomId, username, this.newMessage).subscribe(() => {
        this.messages.push({
          id: Date.now(), // Tymczasowe ID
          chatId: this.chatRoomId,
          senderId: 1, // Symulowany ID użytkownika (możesz go zmienić, jeśli masz więcej informacji)
          content: this.newMessage,
          timestamp: new Date().toISOString()
        });
        this.newMessage = ''; // Czyść pole tekstowe po wysłaniu
        this.loadMessages(); // Odśwież wiadomości
      });
    });
  }


  goToHome(): void {
    this.router.navigate(['/chat']);
  }
}
