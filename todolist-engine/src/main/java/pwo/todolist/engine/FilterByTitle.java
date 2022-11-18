/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dariusz
 */
public class FilterByTitle implements ITodoFilter{
    String containedPhrase;
    FilterByTitle(String containedPhrase){
        this.containedPhrase = containedPhrase;
    }
    
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        containedPhrase = containedPhrase.toUpperCase();
        return currentTodos.stream().filter(t -> t.title.toUpperCase().contains(containedPhrase)).collect(Collectors.toList());
    }
}
