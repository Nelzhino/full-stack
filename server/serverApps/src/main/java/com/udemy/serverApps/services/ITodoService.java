package com.udemy.serverApps.services;

import java.util.List;

import com.udemy.serverApps.models.TodoModel;

public interface ITodoService {

	
	List<TodoModel> getListAll(String username);
	
	TodoModel save(TodoModel todoModel);
	
	TodoModel deleteBy(long id);
	
	TodoModel findById(long id);
}
