/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dariusz
 */
public class FilterByIsImportant implements ITodoFilter {
    boolean isImportant;
    FilterByIsImportant(boolean isImportant){
        this.isImportant = isImportant;
    }
    
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        return currentTodos.stream().filter(t -> t.isImportant == isImportant).collect(Collectors.toList());
    }
}
