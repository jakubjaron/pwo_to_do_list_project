package pwo.todolist.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwo.todolist.db.exception.TodoNotFoundException;
import pwo.todolist.db.model.Todo;
import pwo.todolist.db.repository.TodoRepository;

import java.util.List;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo AddTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAllTodo() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodoById(Long id) {
        return todoRepository.findTodoById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with id: " + id + " was not found."));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteTodoById(id);
    }
}
