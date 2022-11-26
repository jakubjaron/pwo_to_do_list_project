package pwo.todolist.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwo.todolist.db.model.Todo;

import java.util.Optional;

/**
 *
 * @author patryk
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     *
     * @param id - parametr po którym szukamy todo do usunięcia (id)
     */
    void deleteTodoById(Long id);

    /**
     *
     * @param id - parametr po którym szukamy todo (id)
     * @return - zwraca obiekt todo jeżeli zostanie znaleziony
     */
    Optional<Todo> findTodoById(Long id);
}
