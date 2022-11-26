package pwo.todolist.db.exception;

/**
 *
 * @author patryk
 */
public class TodoNotFoundException extends RuntimeException{

    /**
     * Funkcja wyświetlająca komunikat o tym że dane todo już istnieje
     * @param message - parametr tekstowy zawierający treść komunikatu
     */
    public TodoNotFoundException(String message) {
        super(message);
    }
}
