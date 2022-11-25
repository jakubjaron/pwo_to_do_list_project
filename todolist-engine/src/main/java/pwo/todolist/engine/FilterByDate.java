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
 * danego dnia pozyskanego z jCalendar
 * @author dariusz
 */
public class FilterByDate implements ITodoFilter{
    Date date;
    
    /**
     * Konstruktor określający po jakim dniu powinny zostać wyfiltrowane zadania
     * @param date Dzień do filtrowania obiektów Todo
     */
    FilterByDate(Date date){
        this.date = date;
    }
    
    /**
     * Funkcja filtrująca obiekty klasy Todo według podanego dnia
     * @return Wszystkie zadania Todo z podanego dnia
     */
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        return currentTodos.stream().filter(t -> t.date.equals(date)).collect(Collectors.toList());
    }
}
