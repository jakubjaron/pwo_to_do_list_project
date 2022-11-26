/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa zawierająca logikę filtrowania obiektów Todo według
 * frazy występującej w tytule obiektu
 * @author dariusz
 */
public class FilterByTitle implements ITodoFilter{
    String containedPhrase;
    
    /**
     * Konstruktor określający, frazę po której powinny zostać wyfiltrowane obiekty klasy Todo
     * @param containedPhrase Fraza do filtrowania
     */
    FilterByTitle(String containedPhrase){
        this.containedPhrase = containedPhrase;
    }
    
    /**
     * Funkcja filtruje i zwraca listę zadań Todo zawierających podaną frazę. Wyniki zwracania są niezależne od wielkości liter we frazie i w tytule.
     * @return Lista zadań Todo odpowiadająca podanej frazie
     */
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        containedPhrase = containedPhrase.toUpperCase();
        return currentTodos.stream().filter(t -> t.title.toUpperCase().contains(containedPhrase)).collect(Collectors.toList());
    }
}
