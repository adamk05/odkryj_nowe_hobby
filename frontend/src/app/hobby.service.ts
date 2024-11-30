import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HobbyForm } from './hobby-form.model';

@Injectable({
  providedIn: 'root'
})
export class HobbyService {

  private BASE_URL = 'http://localhost:8080/api';

  constructor(private httpClient: HttpClient) { }

  test(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/test');
  }

  getRecommendations(hobby: HobbyForm): Observable<any> {
    return this.httpClient.post<any>(this.BASE_URL + '/recommendations', hobby);
  }

}
