/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Comparator;

/**
 * Klasa sortująca obkiety klasy Todo po tytule
 * @author dariusz
 */
public class SortTodoByTitle implements Comparator<Todo>{
    boolean isReversed = false;
    
    public SortTodoByTitle(){
        
    }
    
    /**
     * Konstruktor określający czy wyniki mają zostać zwrócone w postaci alfabetycznej, czy odwrotnie alfabetycznej
     * @param isReversed Czy dane mają być zwrócone w postaci odwrotnie alfabetycznej 
     */
    public SortTodoByTitle(boolean isReversed){
        this.isReversed = isReversed;
    }
    
    /**
     * Funkcja porównująca dwa zadania Todo według tytułu ignorując wielkość liter
     * @param a Pierwsze zadanie Todo
     * @param b Drugie Zadanie Todo
     * @return Zwraca -1 jeżeli a jest w porządku alfabetycznym przed b. Zwraca 0 jeżeli porównywane są te same tytuły.
     * Zwraca 1 jeżeli w porządku alfabetycznym a następuje po b.
     */
    @Override
    public int compare(Todo a, Todo b) {
        if(isReversed){
            return b.title.compareToIgnoreCase(a.title);
        }
        return a.title.compareToIgnoreCase(b.title);
    }
}
