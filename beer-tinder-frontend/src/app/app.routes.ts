import { Routes } from '@angular/router';
import { provideRouter} from '@angular/router';
import { HomeComponent} from './home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', loadComponent: () => import('./home/home.component').then(m => m.HomeComponent) },
  { path: 'browse-beers', loadComponent: () => import('./browse/browse.component').then(m => m.BrowseComponent) },
  { path: 'chat', loadChildren:() => import('./chat/chat.component').then(m => m.ChatComponent) },
  { path: 'favorites', loadChildren:() => import('./favorites/favorites.component').then(m => m.FavoritesComponent) },
];
