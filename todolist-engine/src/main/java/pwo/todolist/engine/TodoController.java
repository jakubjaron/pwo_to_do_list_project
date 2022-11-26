/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 * Klasa obsługująca czynności związane z zarządzaniem obiektami Todo
 * takie jak tworzenie, usuwanie, sortowanie i filtrowanie obiektów Todo.
 * 
 * @author dariusz
 */
public class TodoController {
    private static TodoController instance;
    private List<Todo> currentTodos = new ArrayList<Todo>();
    
    private TodoController(){
    }
    
    /**
     * Funkcja zwracająca obiekt kontrolera. Jest to zalecany sposób na odwołanie się do kontrolera.
     * @return Obiekt kontrolera
     */
    
    public static TodoController getInstance(){
        if(instance == null){
            instance = new TodoController();
        }
        return instance;
    }
    
    /**
     * Dodaje obiekt Todo do listy aktualnie przechowywanych obiektów
     * @param todo Obiekt który zostanie dodany
     */
    public void AddTodo(Todo todo){
        currentTodos.add(todo);
    }
    
    /**
     * Zwraca listę aktualnych obiektów Todo
     * @return lista aktualnych obiektów 
     */
    public List<Todo> GetTodos(){
        return currentTodos;
    }
    
    /**
     * Usuwa obiekt Todo z listy aktualnie przechowywanych obiektów
     * @param todo Obiekt który zostanie usunięty
     */
    public void RemoveTodo(Todo todo)
    {
        currentTodos.remove(todo);
    }
    
    /**
     * Funkcja sortuje aktualne obiekty Todo i zwraca je w postaci listy
     * @param sortType Typ sortowania określający po którym polu chcemy sortować
     * @return Posortowana lsita obiektów Todo
     */
    public List<Todo> GetTodosInOrder(TodoSorter.SortType sortType){
        List<Todo> todosToSort = new ArrayList<>(currentTodos);
        List<Todo> sortedTodos = TodoSorter.Sort(todosToSort, sortType);
        return sortedTodos;
    }
    
    /**
     * Funkcja, która sprawdza, czy tytuł zawiera podany fragment tekstu, filtruje aktualne obiekty Todo i zwraca obiekty po wyfiltrowaniu
     * @param phrase Fragment tekstu, który będzie wyszukiwany w polu
     * @return Lista obiektów Todo
     */
    public List<Todo> filterTitleByPhrase(String phrase) {
        return new FilterByTitle(phrase).filter();
    }
    
    /**
     * Funkcja, która sprawdza, czy kategoria zawiera podany fragment tekstu, filtruje aktualne obiekty Todo i zwraca obiekty po wyfiltrowaniu
     * @param phrase Fragment tekstu, który będzie wyszukiwany w polu
     * @return Lista obiektów Todo
     */
    public List<Todo> filterCategoryByPhrase(String phrase) {
        return new FilterByCategory(phrase).filter();
    }
    
    /**
     * Funkcja, która wyszukuje wszystkie zadania Todo, które mają termin wykonania ustalony na tą samą datę, co data przekazana w parametrze
     * @param date Data terminu wykonania zadania
     * @return Lista obiektów Todo
     */
    public List<Todo> filterByDate(Date date){
        return new FilterByDate(date).filter();
    }
    
    /**
     * Funkcja zwracająca zadania Todo, które mają ustawioną wartość isImportant na tą podaną w parametrze funkcji
     * @param isImportant Wartość imImportant obiektu Todo
     * @return Lista obiektów Todo
     */
    public List<Todo> filterByIsImportant(boolean isImportant){
        return new FilterByIsImportant(isImportant).filter();
    }
}
