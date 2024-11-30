import { Component, OnInit } from '@angular/core';
import { HobbyCardComponent } from "./hobby-card/hobby-card.component";
import { Hobby } from '../hobby.model';
import { DialogModule } from 'primeng/dialog';
import { HobbyService } from '../hobby.service';

@Component({
  selector: 'app-hobby-suggestions',
  standalone: true,
  imports: [HobbyCardComponent, DialogModule],
  templateUrl: './hobby-suggestions.component.html',
  styleUrl: './hobby-suggestions.component.scss'
})
export class HobbySuggestionsComponent implements OnInit{

  isDialogVisible: boolean = false;
  selectedHobbyIndex: number | undefined = undefined;
  hobbies: Hobby[] = []
  imageAlts: string[] = [
    "Obraz 1",
    "Obraz 2",
    "Obraz 3",
  ]

  constructor(private hobbyService: HobbyService) { }

  ngOnInit(): void {
    this.hobbyService.currentHobbies.subscribe({
      next: (value) => {
        this.hobbies = value!;
        this.hobbies.forEach((hobby) => {
          hobby.category = hobby.category?.replaceAll(' ', '_').toLowerCase();
        });
        console.log(this.hobbies);
      }
    });
  }

  onCardButtonClick(hobbyIndex: number) {
    this.isDialogVisible = true;
    this.selectedHobbyIndex = hobbyIndex
    console.log(this.isDialogVisible, this.selectedHobbyIndex)
  }
  
}
