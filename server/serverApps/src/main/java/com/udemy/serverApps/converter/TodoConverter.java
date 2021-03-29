package com.udemy.serverApps.converter;

import java.util.ArrayList;
import java.util.List;

import com.udemy.serverApps.entities.Todo;
import com.udemy.serverApps.models.TodoModel;

public class TodoConverter {

	
	
	
	public static List<Todo> convertListModelToListEntity(List<TodoModel> todoModels){
		
		List<Todo> todos = new ArrayList<>();
		
		for (TodoModel todoModel : todoModels) {
			
			Todo todo = new Todo();
			todo.setId(todoModel.getId());
			todo.setDescription(todoModel.getDescription());
			todo.setTargetDate(todoModel.getTargetDate());
			todo.setUsername(todoModel.getUsername());
			todo.setDone(todoModel.isDone());	
			
			todos.add(todo);
		}
		
		return todos;
	}
	
	
	public static List<TodoModel> convertListEntityToListModel(List<Todo> todos){
		
		List<TodoModel> todoModels = new ArrayList<>();
		
		for (Todo todo : todos) {
			
			TodoModel todoModel = new TodoModel();
			todoModel.setId(todo.getId());
			todoModel.setDescription(todo.getDescription());
			todoModel.setTargetDate(todo.getTargetDate());
			todoModel.setUsername(todo.getUsername());
			todoModel.setDone(todo.isDone());			
			
			todoModels.add(todoModel);
		}
		
		return todoModels;
	}
	
	
	public static TodoModel convertEntityToModel(Todo todo) {

		TodoModel todoModel = new TodoModel();
		todoModel.setId(todo.getId());
		todoModel.setDescription(todo.getDescription());
		todoModel.setTargetDate(todo.getTargetDate());
		todoModel.setUsername(todo.getUsername());
		todoModel.setDone(todo.isDone());	
		
		return todoModel;
	}
	
	
	
	public static Todo convertModelToEntity(TodoModel todoModel) {
		
		Todo todo = new Todo();
		todo.setId(todoModel.getId());
		todo.setDescription(todoModel.getDescription());
		todo.setTargetDate(todoModel.getTargetDate());
		todo.setUsername(todoModel.getUsername());
		todo.setDone(todoModel.isDone());	
		
		
		return todo;
		
	}
	
	
}
