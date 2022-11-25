/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Comparator;

/**
 * Klasa sortująca obiekty zadań Todo po nazwie kategorii
 * @author dariusz
 */
public class SortTodoByCategory implements Comparator<Todo>{
    boolean isReversed = false;
    
    public SortTodoByCategory(){
        
    }
    
     /**
     * Konstruktor określający czy wyniki mają zostać zwrócone w postaci alfabetycznej, czy odwrotnie alfabetycznej
     * @param isReversed Czy dane mają być zwrócone w postaci odwrotnie alfabetycznej 
     */
    public SortTodoByCategory(boolean isReversed){
        this.isReversed = isReversed;
    }
    
    /**
     * Funkcja porównująca dwa zadania Todo według nazwy kategorii ignorując wielkość liter.
     * @param o1 Pierwsze zadanie Todo
     * @param o2 Drugie Zadanie Todo
     * @return Zwraca -1 jeżeli o1 jest w porządku alfabetycznym przed o2. Zwraca 0 jeżeli porównywane są te same nazwy kategorii.
     * Zwraca 1 jeżeli w porządku alfabetycznym o1 następuje po o2.
     */
    @Override
    public int compare(Todo o1, Todo o2) {
        if(isReversed){
            return o2.category.compareToIgnoreCase(o1.category);
        }
        return o1.category.compareToIgnoreCase(o2.category);
    }
    
}
