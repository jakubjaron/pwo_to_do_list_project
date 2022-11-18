/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author dariusz
 */
public class TodoController {
    private static TodoController instance;
    private List<Todo> currentTodos = new ArrayList<Todo>();
    
    private TodoController(){
    }
    
    public static TodoController getInstance(){
        if(instance == null){
            instance = new TodoController();
        }
        return instance;
    }
    
    public void AddTodo(Todo todo){
        currentTodos.add(todo);
    }
    
    public List<Todo> GetTodos(){
        return currentTodos;
    }
    
    public void RemoveTodo(Todo todo)
    {
        currentTodos.remove(todo);
    }
    
    public List<Todo> GetTodosInOrder(TodoSorter.SortType sortType){
        return TodoSorter.Sort(currentTodos, sortType);
    }
    
    public List<Todo> filterTitleByPhrase(String phrase) {
        return new FilterByTitle(phrase).filter();
    }
    public List<Todo> filterCategoryByPhrase(String phrase) {
        return new FilterByCategory(phrase).filter();
    }
    public List<Todo> filterByDate(Date date){
        return new FilterByDate(date).filter();
    }
    public List<Todo> filterByIsImportant(boolean isImportant){
        return new FilterByIsImportant(isImportant).filter();
    }
}
