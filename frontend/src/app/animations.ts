import {
  trigger,
  state,
  style,
  animate,
  transition
} from '@angular/animations';

export const fadeAnimation = trigger('fadeAnimation', [
    transition(':enter', [ // Element entering the DOM (fade-in)
      style({ opacity: 0 }),
      animate('0.5s ease-in', style({ opacity: 1 }))
    ]),
    transition(':leave', [ // Element leaving the DOM (fade-out)
      animate('0.5s ease-out', style({ opacity: 0 }))
    ])
  ])