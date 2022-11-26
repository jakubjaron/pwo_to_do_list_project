package pwo.todolist.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwo.todolist.db.exception.TodoNotFoundException;
import pwo.todolist.db.model.Todo;
import pwo.todolist.db.repository.TodoRepository;

import java.util.List;

/**
 *
 * @author patryk
 */
@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    /**
     *
     * @param todoRepository - wstrzyknięcie repozytorium todo
     */
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     *
     * @param todo - przekazujemy obiekt todo
     * @return zapisuje obiekt todo do bazy danych
     */
    public Todo AddTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     *
     * @return wyszukuje wszystkie obiekty todo z bazy danych
     */
    public List<Todo> findAllTodo() {
        return todoRepository.findAll();
    }

    /**
     *
     * @param todo - przekazujemny obiekt todo
     * @return aktualizujemy przekazany obiekt todo
     */
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     *
     * @param id - parametr typu int po którym szukamy obiektu todo w bazie danych
     * @return jeżeli todo istnieje zwracamy je, w przeciwwnym wypadku wyrzucony zostaje wyjątek
     */
    public Todo findTodoById(Long id) {
        return todoRepository.findTodoById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with id: " + id + " was not found."));
    }

    /**
     *
     * @param id - parametr typu int po którym szukamy obiektu todo w bazie danych do usunięcia
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteTodoById(id);
    }
}
