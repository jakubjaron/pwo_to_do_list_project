/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.todolist.engine;

import java.util.*;

/**
 *
 * @author dariusz
 */
public class Todo implements Comparable<Todo>{
    String title;
    String category;
    Date date;
    boolean isImportant;
    
    
    public Todo(String title, String category, Date date, boolean isImportant){
        this.title = title;
        this.category = category;
        this.date = date;
        this.isImportant = isImportant;
    }

    @Override
    public int compareTo(Todo compareTodo) {
        String compareTitle = ((Todo) compareTodo).title;
        return compareTitle.compareTo(title);
    }
    
    
}
