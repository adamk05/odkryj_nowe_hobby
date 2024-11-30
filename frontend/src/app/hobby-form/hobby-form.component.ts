import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HobbyForm } from '../hobby-form.model';
import { HobbyService } from '../hobby.service';

@Component({
  selector: 'app-hobby-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './hobby-form.component.html',
  styleUrl: './hobby-form.component.scss'
})
export class HobbyFormComponent {

  hobby: HobbyForm = new HobbyForm();
  step: number = 0;

  constructor(private hobbyService: HobbyService) { }

  proceed(): void {
    this.hobbyService.getRecommendations(this.hobby).subscribe({
      next: (value) => {
        console.log(value);
      }
    })
  }

  stepAhead(): void {
    this.step++;
  }

  riskyActivities(): void {
    this.hobby.riskyActivities = true;
    this.stepAhead();
  }

  isIndividualist(): void {
    this.hobby.isIndividualist = true;
    this.stepAhead();
  }

  isSpontanic(): void {
    this.hobby.isSpontanic = true;
    this.stepAhead();
  }

  freshAirActivities(): void {
    this.hobby.freshAirActivities = true;
    this.stepAhead();
  }

  isCreative(): void {
    this.hobby.isCreative = true;
    this.stepAhead();
  }

  manualActivities(): void {
    this.hobby.manualActivities = true;
    this.stepAhead();
  }

  likesScience(): void {
    this.hobby.likesScience = true;
    this.stepAhead();
  }

  likesHistory(): void {
    this.hobby.likesHistory = true;
    this.stepAhead();
  }

  likesNature(): void {
    this.hobby.likesNature = true;
    this.proceed();
  }


}
