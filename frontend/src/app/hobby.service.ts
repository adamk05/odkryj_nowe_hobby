import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HobbyService {

  constructor(private httpClient: HttpClient) { }

  test(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/api/test');
  }

}
