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
public class SortTodoByCategory implements Comparator<Todo>{
    boolean isReversed = false;
    
    public SortTodoByCategory(){
        
    }
    
    public SortTodoByCategory(boolean isReversed){
        this.isReversed = isReversed;
    }
    
    @Override
    public int compare(Todo o1, Todo o2) {
        if(isReversed){
            return o1.category.compareToIgnoreCase(o1.category);
        }
        return o2.category.compareToIgnoreCase(o1.category);
    }
    
}
