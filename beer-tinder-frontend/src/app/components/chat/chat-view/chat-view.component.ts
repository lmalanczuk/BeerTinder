import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChatService, Message } from '../../../services/chat.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-chat-view',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './chat-view.component.html',
  styleUrl: './chat-view.component.css'
})
export class ChatViewComponent implements OnInit {
  chatId!: number;
  messages: Message[] = [];
  newMessage: string = '';

  constructor(private route: ActivatedRoute, private chatService: ChatService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.chatId = +params['userId'];
      this.loadMessages();
    });
  }

  loadMessages(): void {
    this.chatService.getMessages(this.chatId).subscribe(messages => {
      this.messages = messages;
    });
  }

  sendMessage(): void {
    if (!this.newMessage.trim()) return;
    this.chatService.sendMessage(this.chatId, this.newMessage).subscribe(() => {
      this.newMessage = '';
      this.loadMessages();
    });
  }
}
