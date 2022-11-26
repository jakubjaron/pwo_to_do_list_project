/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa zawierająca logikę filtrowania obiektów Todo według 
 * frazy występującej w kategorii obiektu
 * @author dariusz
 */
public class FilterByCategory implements ITodoFilter {

    String containedPhrase;

    /**
     * Konstruktor umożliwiający podanie frazy potrzebnej do filtrowania zadań Todo
     * @param containedPhrase Fraza do sortowania
     */
    FilterByCategory(String containedPhrase) {
        this.containedPhrase = containedPhrase;
    }

    /**
     * Funkcja filtrująca zadania Todo według nazwy kategorii z pomocą frazy podanej w konstruktorze. Nazwa kategorii i fraza są niezależne od wielkości liter
     * @return Lista zadań Todo odpowiadająca frazie
     */
    @Override
    public List<Todo> filter() {
        List<Todo> todos = TodoController.getInstance().GetTodos();
        containedPhrase = containedPhrase.toUpperCase();
        return todos.stream().filter(t -> t.category.toUpperCase().contains(containedPhrase)).collect(Collectors.toList());
    }
}
