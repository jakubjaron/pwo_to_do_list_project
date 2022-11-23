package pwo.todolist.db.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pwo.todolist.db.model.Todo;

/**
 *
 * @author patryk
 */
public class TodoNotFoundExceptionTest {
    

    @Test
    public void testSomeMethod() {
        System.out.println("Test: TodoNotFoundException");
        Todo todo = new Todo();
        Exception exception;
        exception = assertThrows(TodoNotFoundException.class, ()
                -> todo.getId());
        assertTrue(exception.getMessage()
                .contains("Todo with id " + todo.getId() + " was not found"));
    }
    
}
