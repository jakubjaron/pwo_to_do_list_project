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
public class SortTodoByTitle implements Comparator<Todo>{
    boolean isReversed = false;
    
    public SortTodoByTitle(){
        
    }
    
    public SortTodoByTitle(boolean isReversed){
        this.isReversed = isReversed;
    }
    
    @Override
    public int compare(Todo a, Todo b) {
        if(isReversed){
            return b.title.compareToIgnoreCase(a.title);
        }
        return a.title.compareToIgnoreCase(b.title);
    }
}
