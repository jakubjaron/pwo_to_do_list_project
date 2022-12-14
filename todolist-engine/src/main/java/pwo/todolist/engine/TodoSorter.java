/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.*;

/**
 * Klasa sortująca obiekty Todo według wybranych pól.
 * @author dariusz
 */
public class TodoSorter {
    
    /**
     * Typ wyliczeniowy służący do określenia typu sortowania
     */
    public enum SortType{
        LEAST_TIME_REMANING,
        MOST_TIME_REMANING,
        TITLE_ALPHABETICAL,
        TITLE_REVERSE_ALPHABETICAL,
        CATEGORY_ALPHABETICAL,
        CATEGORY_REVERSE_ALPHABETICAL
    }
    
    /**
     * Funkcja sortująca wszystkie aktualne zadania Todo i zwracające te w odpowiedniej kolejności
     * @param todos Zadania Todo do posortowania
     * @param sortType Typ sortowania
     * @return Lista zadań Todo
     */
    public static List<Todo> Sort(List<Todo> todos, SortType sortType){
        switch(sortType){
            case LEAST_TIME_REMANING:
                Collections.sort(todos, new SortTodoByDate());
                break;
            case MOST_TIME_REMANING:
                Collections.sort(todos, new SortTodoByDate(true));
                break;
            case TITLE_ALPHABETICAL:
                Collections.sort(todos, new SortTodoByTitle());
                break;
            case TITLE_REVERSE_ALPHABETICAL:
                Collections.sort(todos, new SortTodoByTitle(true));
                break;
            case CATEGORY_ALPHABETICAL:
                Collections.sort(todos, new SortTodoByCategory());
                break;
            case CATEGORY_REVERSE_ALPHABETICAL:
                Collections.sort(todos, new SortTodoByCategory(true));
                break;
        }
        return todos;
    }
    
}
