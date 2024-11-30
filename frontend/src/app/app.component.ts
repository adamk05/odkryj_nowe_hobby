import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HobbyService } from './hobby.service';
import { HobbyFormComponent } from './hobby-form/hobby-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, HobbyFormComponent],
  providers: [HobbyService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  title = 'frontend';

  constructor(private hobbyService: HobbyService) { }

  ngOnInit(): void {
    this.hobbyService.test().subscribe({
      next: (value) => {
        console.log(value);
      }
    })
  }

}
