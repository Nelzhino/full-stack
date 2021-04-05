import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from './../app.constants';
import { UserDto } from '../models/UserDto';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }


  saveRegisterUser(userDto: UserDto) {
    return this.http.post(`${API_URL}/register`, userDto);
  }
}
