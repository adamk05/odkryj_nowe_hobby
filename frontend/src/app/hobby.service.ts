import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HobbyForm } from './hobby-form.model';
import { Hobby } from './hobby.model';

@Injectable({
  providedIn: 'root'
})
export class HobbyService {

  private BASE_URL = 'http://localhost:8080/api';
  private hobbySource = new BehaviorSubject<Hobby[] | null>(null);
  currentHobbies = this.hobbySource.asObservable();

  constructor(private httpClient: HttpClient) { }

  test(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/test');
  }

  getRecommendations(hobby: HobbyForm): Observable<Hobby[]> {
    return this.httpClient.post<Hobby[]>(this.BASE_URL + '/recommendations', hobby);
  }

  changeHobbies(hobbies: Hobby[]) {
    this.hobbySource.next(hobbies);
  }

}
