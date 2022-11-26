/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pwo.todolist.engine;

import java.util.Date;

public class TodolistEngine {

    public static void main(String[] args) {
        Date date1 = new Date(2020, 11, 20);
        Todo todo1 = new Todo("Nie robić inżynierki", "Zabawa", date1, true);
        Date date2 = new Date(2020, 11, 21);
        Todo todo2 = new Todo("Zrobić inżynierkę", "Szkoła", date2, false);
        Date date3 = new Date(2020, 11, 19);
        Todo todo3 = new Todo("Ale co robić", "Relaks", date3, false);
        TodoController.getInstance().AddTodo(todo1);
        TodoController.getInstance().AddTodo(todo2);
        TodoController.getInstance().AddTodo(todo3);

        System.out.println("Wszystkie todo:");
        for (Todo t : TodoController.getInstance().GetTodos()) {
            System.out.println(t.title);
        }

        System.out.println("Po sortowaniu title:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.TITLE_ALPHABETICAL)) {
            System.out.println(t.title);
        }
        System.out.println("Po sortowaniu reverse title:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.TITLE_REVERSE_ALPHABETICAL)) {
            System.out.println(t.title);
        }
        System.out.println("Po sortowaniu category:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.CATEGORY_ALPHABETICAL)) {
            System.out.println(t.category);
        }
        System.out.println("Po sortowaniu category reverse:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.CATEGORY_REVERSE_ALPHABETICAL)) {
            System.out.println(t.category);
        }
        System.out.println("Po sortowaniu least time remaning:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.LEAST_TIME_REMANING)) {
            System.out.println(t.date);
        }
        System.out.println("Po sortowaniu most time remaning:");
        for (Todo t : TodoController.getInstance().GetTodosInOrder(TodoSorter.SortType.MOST_TIME_REMANING)) {
            System.out.println(t.date);
        }

        System.out.println("Po filtrowaniu tytułu z frazą \'inż\':");
        for (Todo t : TodoController.getInstance().filterTitleByPhrase("inż")) {
            System.out.println(t.title);
        }
        System.out.println("Po filtrowaniu tytułu z frazą \'N\':");
        for (Todo t : TodoController.getInstance().filterTitleByPhrase("N")) {
            System.out.println(t.title);
        }
        System.out.println("Po filtrowaniu kategorii z frazą \'z\':");
        for (Todo t : TodoController.getInstance().filterCategoryByPhrase("z")) {
            System.out.println(t.category);
        }
        System.out.println("Po filtrowaniu kategorii z frazą \'Z\':");
        for (Todo t : TodoController.getInstance().filterCategoryByPhrase("Z")) {
            System.out.println(t.category);
        }
        System.out.println("Po filtrowaniu po dacie 20 Grudzień 2020:");
        for (Todo t : TodoController.getInstance().filterByDate(new Date(2020,11,20))) {
            System.out.println(t.title + " " + t.date);
        }
        System.out.println("Po filtrowaniu \'ważnych zadań\':");
        for (Todo t : TodoController.getInstance().filterByIsImportant(true)) {
            System.out.println(t.title + " " + t.isImportant);
        }
        System.out.println("Po filtrowaniu \'nieważnych zadań\':");
        for (Todo t : TodoController.getInstance().filterByIsImportant(false)) {
            System.out.println(t.title + " " + t.isImportant);
        }

    }
}
