package pwo.todolist.db.service;

import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pwo.todolist.db.model.Todo;
import pwo.todolist.db.repository.TodoRepository;

/**
 *
 * @author patryk
 */
public class TodoServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TodoRepository repository;

    @Test
    public void isRepoEmpty() {
        Iterable<Todo> todos = repository.findAll();

        assertThat(todos).isEmpty();
    }

    @Test
    public void saveTodo() {
        Long id = 1L;
        Date data = new Date();
        Todo todo = repository.save(new Todo(id, "title", "category", data, true));

        assertThat(todo).hasFieldOrPropertyWithValue("title", "category");

    }

    @Test
    public void deleteAllTodos() {
        Long id = 1L;
        Long id2 = 2L;
        Date data = new Date();
        Date data2 = new Date();
        entityManager.persist(new Todo(id, "title", "category", data, true));
        entityManager.persist(new Todo(id2, "title2", "category2", data2, true));

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    public void deleteTodoById() {
        Long id = 1L;
        Date data = new Date();
        entityManager.persist(new Todo(id, "title", "category", data, true));

        repository.deleteTodoById(id);

        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    public void findAllTodos() {
        Long id = 1L;
        Long id2 = 2L;
        Long id3 = 3L;
        Date data = new Date();

        Todo todo1 = new Todo(id, "title", "category", data, true);
        entityManager.persist(todo1);

        Todo todo2 = new Todo(id2, "title2", "category2", data, true);
        entityManager.persist(todo2);

        Todo todo3 = new Todo(id3, "title3", "category3", data, true);
        entityManager.persist(todo3);

        Iterable<Todo> todos = repository.findAll();

        assertThat(todos).hasSize(3).contains(todo1, todo2, todo3);
    }

    @Test
    public void findTodoById() {
        Long id = 1L;
        Long id2 = 2L;
        Date data = new Date();

        Todo todo1 = new Todo(id, "title", "category", data, true);
        entityManager.persist(todo1);

        Todo todo2 = new Todo(id2, "title2", "category2", data, true);
        entityManager.persist(todo2);

        Optional<Todo> getTodo = repository.findTodoById(todo2.getId());

        assertThat(getTodo).isEqualTo(todo2);
    }

}
