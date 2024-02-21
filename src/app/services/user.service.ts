import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = "http://localhost:8080/api/auth/register"

  constructor(private httpClient:HttpClient) { }

  registerUser(user:User): Observable<User>{
    return this.httpClient.post<User>(this.apiUrl, user);
  }
}
