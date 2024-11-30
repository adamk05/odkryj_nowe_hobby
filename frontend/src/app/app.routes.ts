import { Routes } from '@angular/router';
import { HobbyForm } from './hobby-form.model';
import { HobbySuggestionsComponent } from './hobby-suggestions/hobby-suggestions.component';
import { HobbyFormComponent } from './hobby-form/hobby-form.component';

export const routes: Routes = [
    {
        path: '',
        component: HobbyFormComponent
    },
    {
        path: 'suggestions',
        component: HobbySuggestionsComponent
    }
];
