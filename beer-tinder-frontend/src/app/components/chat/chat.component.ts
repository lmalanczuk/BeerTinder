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
      console.log("Otrzymane wiadomości:", messages); // ✅ Sprawdzenie danych
      this.messages = messages;
    });
  }


  sendMessage(): void {
    if (!this.newMessage.trim()) return;

    const newMsg: Message = {
      id: Date.now(), // Tymczasowe ID
      chatId: this.chatRoomId,
      senderId: 1, // Symulujemy użytkownika nr 1
      text: this.newMessage,
      timestamp: new Date().toISOString()
    };

    this.messages.push(newMsg); // ✅ Dodajemy wiadomość lokalnie przed wysłaniem

    this.chatService.sendMessage(this.chatRoomId, this.newMessage).subscribe(() => {
      this.newMessage = ''; // Czyszczenie pola tekstowego
      this.loadMessages(); // ✅ Pobranie aktualnych wiadomości z backendu
    });
  }

  goToHome(): void {
    this.router.navigate(['/chat']);
  }
}
