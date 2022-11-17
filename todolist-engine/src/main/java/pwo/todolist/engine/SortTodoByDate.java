/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Comparator;

/**
 *
 * @author dariusz
 */
public class SortTodoByDate implements Comparator<Todo> {
    boolean isReversed = false;
    
    public SortTodoByDate(){
        
    }
    
    public SortTodoByDate(boolean isReversed){
        this.isReversed = isReversed;
    }
    
    @Override
    public int compare(Todo o1, Todo o2) {
        if(isReversed){
            return o2.date.compareTo(o1.date);
        }
        return o1.date.compareTo(o2.date);
    }
}
