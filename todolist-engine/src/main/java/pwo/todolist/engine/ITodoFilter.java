/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pwo.todolist.engine;

import java.util.List;

/**
 * Interfejs umożliwiający spójne wywołanie operacji filter(), operacji filtrowania zadań Todo
 * na każdym obiekcie implementującym interfejs.
 * @author dariusz
 */
public interface ITodoFilter {
    List<Todo> filter();
}
