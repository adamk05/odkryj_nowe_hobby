import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HobbyService } from './hobby.service';
import { HobbyFormComponent } from './hobby-form/hobby-form.component';
import { faMoon, faSun } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, HobbyFormComponent, FontAwesomeModule],
  providers: [HobbyService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'frontend';
  faMoon = faMoon;
  faSun = faSun;
  icon: any;

  enableDarkTheme() {
    document.body.classList.add('dark-theme');
    localStorage.setItem('dark-theme', 'true');
    this.icon = this.faSun;
  }

  enableLightTheme() {
    document.body.classList.remove('dark-theme');
    localStorage.setItem('dark-theme', 'false');
    this.icon = this.faMoon;
  }

  applyStoredTheme() {
    const isDarkTheme = localStorage.getItem('dark-theme') === 'true';
    if (isDarkTheme) {
      this.enableDarkTheme();
      this.icon = this.faSun;
    } else {
      this.enableLightTheme();
      this.icon = this.faMoon;
    }
  }

  isDarkThemeEnabled(): boolean {
    return document.body.classList.contains('dark-theme');
  }

  switchTheme(): void {
    if(this.isDarkThemeEnabled()) {
      this.enableLightTheme();
    } else {
      this.enableDarkTheme();
    }
  }

  constructor(private hobbyService: HobbyService) { }

  ngOnInit(): void {
    this.applyStoredTheme();
  }

}
