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
public class FilterByCategory implements ITodoFilter {

    String containedPhrase;

    FilterByCategory(String containedPhrase) {
        this.containedPhrase = containedPhrase;
    }

    @Override
    public List<Todo> filter() {
        List<Todo> todos = TodoController.getInstance().GetTodos();
        containedPhrase = containedPhrase.toUpperCase();
        return todos.stream().filter(t -> t.category.toUpperCase().contains(containedPhrase)).collect(Collectors.toList());
    }
}
