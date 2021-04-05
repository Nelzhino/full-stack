import { TODO_JPA_API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from '../../list-todos/list-todos.component';
import { BasicAuthenticationService } from '../basic-authentication.service';
import { TodoDto } from 'src/app/models/TodoDto';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(
    private http: HttpClient,
    private basicAuthenticationService: BasicAuthenticationService
  ) { }


  retrieveAllTodos() {
    return this.http.get<Todo[]>(`${TODO_JPA_API_URL}/users/${this.basicAuthenticationService.getAuthenticatedUser()}/todos`);
  }

  deleteTodo(id) {
    return this.http.delete(`${TODO_JPA_API_URL}/users/${this.basicAuthenticationService.getAuthenticatedUser()}/todos/${id}`);
  }

  retrieveTodo(id) {
    return this.http.get<Todo>(`${TODO_JPA_API_URL}/users/${this.basicAuthenticationService.getAuthenticatedUser()}/todos/${id}`);
  }

  updateTodo(id, todo: TodoDto) {
    return this.http.put(
          `${TODO_JPA_API_URL}/users/todos/${id}`
                , todo);
  }

  createTodo(todo: TodoDto) {
    console.log(this.basicAuthenticationService.getAuthenticatedUser());
    todo.username = this.basicAuthenticationService.getAuthenticatedUser()
    return this.http.post(
              `${TODO_JPA_API_URL}/users/todos`, todo);
  }

}
