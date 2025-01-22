import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {Button, ButtonDirective} from 'primeng/button';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  imports: [
    Button,
    ButtonDirective
  ]
})
export class UserProfileComponent {
  user = {
    name: 'Katarzyna Kowalczyk',
    email: 'katarzyna_kowalczyk@example.com',
    phone: '+48 213 769 420',
    address: 'Katowice, Polska',
    imageUrl: 'https://i.imgur.com/O2j9VbP.jpeg', // Placeholder URL for profile image
    bio: ' miłośniczka piw rzemieślniczych, uwielbia odkrywać nowe smaki i odwiedzać lokalne browary. Jej ulubionym stylem jest stout, w wolnym czasie chętnie uczestniczy w degustacjach i piwnych festiwalach.',
  };

  constructor(private router: Router) {}

  goToHome(): void {
    this.router.navigate(['/']);
  }

}
