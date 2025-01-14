import { Routes } from '@angular/router';
import {ChatViewComponent} from './components/chat/chat-view/chat-view.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', loadComponent: () => import('./home/home.component').then(m => m.HomeComponent) },
  { path: 'browse-beers', loadComponent: () => import('./browse/browse.component').then(m => m.BrowseComponent) },
  { path: 'matches', loadComponent: () => import('./components/match/match.component').then(m => m.MatchComponent) },
  { path: 'chat', loadComponent: () => import('./components/chat/chat-view/chat-view.component').then(m => m.ChatViewComponent) },
  { path: 'chat/:chatRoomId', loadComponent: () => import('./components/chat/chat.component').then(m => m.ChatComponent) }
];
