import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onLogin(): void {
    if (this.email === 'katarzyna_kowalczyk@example.com' && this.password === 'password') {
      alert('Login successful!');
      this.router.navigate(['/home']);
    } else {
      alert('Invalid email or password.');
    }
  }
}
