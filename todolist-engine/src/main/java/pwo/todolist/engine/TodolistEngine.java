/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pwo.todolist.engine;

import java.util.Date;

/**
 *
 * @author Kuba
 */
public class TodolistEngine {

    public static void main(String[] args) {
        TodoController controller = new TodoController();
        Date date1 = new Date(2020,11,20);
        Todo todo1 = new Todo("Zrobić inżynierkę", "Szkoła", date1, true);
        Date date2 = new Date(2020,11,21);
        Todo todo2 = new Todo("Nie robić inżynierki", "Zabawa", date2, false);
        Date date3 = new Date(2020,11,19);
        Todo todo3 = new Todo("Ale co robić", "Relaks", date3, false);
        controller.AddTodo(todo1);
        controller.AddTodo(todo2);
        controller.AddTodo(todo3);
        
        System.out.println("Wszystkie todo:");
        for(Todo t : controller.GetTodos()){
            System.out.println(t.title);
        }
        
        System.out.println("Po sortowaniu title:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.TITLE_ALPHABETICAL)){
            System.out.println(t.title);
        }
        System.out.println("Po sortowaniu reverse title:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.TITLE_REVERSE_ALPHABETICAL)){
            System.out.println(t.title);
        }
        System.out.println("Po sortowaniu category:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.CATEGORY_ALPHABETICAL)){
            System.out.println(t.category);
        }
        System.out.println("Po sortowaniu category reverse:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.CATEGORY_REVERSE_ALPHABETICAL)){
            System.out.println(t.category);
        }
        System.out.println("Po sortowaniu least time remaning:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.LEAST_TIME_REMANING)){
            System.out.println(t.date);
        }
        System.out.println("Po sortowaniu most time remaning:");
        for(Todo t : controller.GetTodosInOrder(TodoSorter.SortType.MOST_TIME_REMANING)){
            System.out.println(t.date);
        }
    }
}
