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
public class FilterByDate implements ITodoFilter{
    Date date;
    FilterByDate(Date date){
        this.date = date;
    }
    
    @Override
    public List<Todo> filter(){
        List<Todo> currentTodos = TodoController.getInstance().GetTodos();
        return currentTodos.stream().filter(t -> t.date.equals(date)).collect(Collectors.toList());
    }
}
