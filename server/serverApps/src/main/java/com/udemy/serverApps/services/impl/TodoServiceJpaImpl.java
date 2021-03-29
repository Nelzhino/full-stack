package com.udemy.serverApps.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.serverApps.converter.TodoConverter;
import com.udemy.serverApps.entities.Todo;
import com.udemy.serverApps.models.TodoModel;
import com.udemy.serverApps.repositories.TodoRepository;
import com.udemy.serverApps.services.ITodoService;

@Service("todoServiceJpa")
public class TodoServiceJpaImpl implements ITodoService{
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<TodoModel> getListAll(String username) {
		return TodoConverter.convertListEntityToListModel(todoRepository.findByUsername(username));
	}

	@Override
	public TodoModel deleteBy(long id) {
		
		Todo todo = todoRepository.findById(id).get();		
		todoRepository.delete(todo);	
		
		return TodoConverter.convertEntityToModel(todo);
	}

	@Override
	public TodoModel findById(long id) {
		return TodoConverter.convertEntityToModel(todoRepository.findById(id).get());
	}

	@Override
	public TodoModel save(TodoModel todoModel) {
		Todo todo = todoRepository.save(TodoConverter.convertModelToEntity(todoModel));
		todoModel.setId(todo.getId());
		return todoModel;
	}

	
	
}
