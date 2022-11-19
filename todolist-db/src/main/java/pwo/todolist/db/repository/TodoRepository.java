package pwo.todolist.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwo.todolist.db.model.Todo;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    void deleteTodoById(Long id);
    Optional<Todo> findTodoById(Long id);
}
