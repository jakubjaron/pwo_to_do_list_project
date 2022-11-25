/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa zawierająca logikę filtrowania obiektów {@Link Todo} według 
 * zaznaczonej opcji isImportant
 * @author dariusz
 */
public class FilterByIsImportant implements ITodoFilter {
    boolean isImportant;
    
    /**
     * Konstruktor definiujący, czy obiekty powinny zostać wyfiltrowane według opcji isImportant ustawionej na false, czy true
     * @param isImportant Czy wyfiltrować obiekty z zaznaczoną opcją isImportant na true
     */
    FilterByIsImportant(boolean isImportant){
        this.isImportant = isImportant;
    }
    
    /**
     * Funkcja filtrująca zadania Todo według opcji isImportant zawartej w konstruktorze
     * @return Lista zadań Todo spełniających warunek isImportant
     */
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        return currentTodos.stream().filter(t -> t.isImportant == isImportant).collect(Collectors.toList());
    }
}
