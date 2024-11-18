import { Routes } from '@angular/router';
import { provideRouter} from '@angular/router';
import { HomeComponent} from './home/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'browse-beers', loadChildren: () => import('./browse/browse.component').then(m => m.BrowseComponent) },
  { path: 'chat', loadChildren:() => import('./chat/chat.component').then(m => m.ChatComponent) },
  { path: 'favorites', loadChildren:() => import('./favorites/favorites.component').then(m => m.FavoritesComponent) },
];
