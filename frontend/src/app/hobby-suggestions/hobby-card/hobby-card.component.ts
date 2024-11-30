import { Component, EventEmitter, input, Input, Output } from '@angular/core';
import { Hobby } from '../../hobby.model';

@Component({
  selector: 'app-hobby-card',
  standalone: true,
  imports: [],
  templateUrl: './hobby-card.component.html',
  styleUrl: './hobby-card.component.scss'
})
export class HobbyCardComponent {
  @Input() 
  hobby!: Hobby;
  @Input()
  imageSrc!: string;
  imageAlt = "wwewewe"

  @Output() onButtonClick= new EventEmitter<void>();

  notifyParent() {
    this.onButtonClick.emit();
  }
}
