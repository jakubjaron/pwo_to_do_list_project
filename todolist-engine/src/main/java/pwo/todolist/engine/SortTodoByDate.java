/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Comparator;

/**
 * Klasa sortująca dni wykonania zadania Todo zależnie od ustalonego terminu wykonania zadania.
 * Klasa zwraca dni od najmniejszej liczby dni wykonania zadania, do najpóźniejszych.
 * Klasa może zwrócić wyniki, w których liczba dni do wykonania zadania jest ujemna (ponieważ termin wykonania zadania już minął).
 * @author dariusz
 */
public class SortTodoByDate implements Comparator<Todo> {
    boolean isReversed = false;
    
    public SortTodoByDate(){
        
    }
    
    /**
     * Konstruktor określający czy wyniki mają zostać zwrócone w postaci od najwcześniejszych dni wykonania zadania, czy od najpóźniejszych
     * @param isReversed Czy dane mają być zwrócone w postaci od dni najpóźniejszych 
     */
    public SortTodoByDate(boolean isReversed){
        this.isReversed = isReversed;
    }
    /**
     * Funkcja porównująca dwa zadania Todo według daty.
     * @param o1 Pierwsze zadanie Todo
     * @param o2 Drugie Zadanie Todo
     * @return Zwraca -1 jeżeli dzień a występuje przed dniem b. Zwraca 0 jeżeli porównywane są te same daty.
     * Zwraca 1 jeżeli dzień a następuje po dniu b.
     */
    @Override
    public int compare(Todo o1, Todo o2) {
        if(isReversed){
            return o2.date.compareTo(o1.date);
        }
        return o1.date.compareTo(o2.date);
    }
}
