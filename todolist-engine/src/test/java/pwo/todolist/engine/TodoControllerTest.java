/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pwo.todolist.engine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dariusz
 */
public class TodoControllerTest {
    static List<Todo> todos;
    public TodoControllerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        Date date1 = new Date(2020, 11, 20);
        Todo todo1 = new Todo("Nie robić inżynierki", "Zabawa", date1, true);
        Date date2 = new Date(2020, 11, 21);
        Todo todo2 = new Todo("Zrobić inżynierkę", "Szkoła", date2, false);
        Date date3 = new Date(2020, 11, 19);
        Todo todo3 = new Todo("Ale co robić", "Relaks", date3, false);
        TodoController.getInstance().AddTodo(todo1);
        TodoController.getInstance().AddTodo(todo2);
        TodoController.getInstance().AddTodo(todo3);
        todos = TodoController.getInstance().GetTodos();
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of GetTodosInOrderTitleAlphabetical method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testGetTodosInOrderTitleAlphabetical() {
        System.out.println("GetTodosInOrder");
        TodoSorter.SortType sortType = TodoSorter.SortType.TITLE_ALPHABETICAL;
        
        List<Todo> result = TodoController.getInstance().GetTodosInOrder(sortType);
        
        assertEquals(todos.get(2), result.get(0));
        assertEquals(todos.get(0), result.get(1));
        assertEquals(todos.get(1), result.get(2));
    }
    
    /**
     * Test of GetTodosInOrderTitleReverseAlphabetical method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testGetTodosInOrderTitleReverseAlphabetical() {
        System.out.println("GetTodosInOrder");
        TodoSorter.SortType sortType = TodoSorter.SortType.TITLE_REVERSE_ALPHABETICAL;
        
        List<Todo> result = TodoController.getInstance().GetTodosInOrder(sortType);
        assertEquals(todos.get(1).title, result.get(0).title);
        assertEquals(todos.get(0).title, result.get(1).title);
        assertEquals(todos.get(2).title, result.get(2).title);
    }
    
    
    
        /**
     * Test of GetTodosInOrderCategroyAlphabetical method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testGetTodosInOrderCategoryAlphabetical() {
        System.out.println("GetTodosInOrder");
        TodoSorter.SortType sortType = TodoSorter.SortType.CATEGORY_ALPHABETICAL;
        
        List<Todo> result = TodoController.getInstance().GetTodosInOrder(sortType);
        
        assertEquals(todos.get(2), result.get(0));
        assertEquals(todos.get(1), result.get(1));
        assertEquals(todos.get(0), result.get(2));
    }

        /**
     * Test of GetTodosInOrderCategoryReverseAlphabetical method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testGetTodosInOrderCategoryReverseAlphabetical() {
        System.out.println("GetTodosInOrder");
        TodoSorter.SortType sortType = TodoSorter.SortType.CATEGORY_REVERSE_ALPHABETICAL;
        
        List<Todo> result = TodoController.getInstance().GetTodosInOrder(sortType);
        
        assertEquals(todos.get(0), result.get(0));
        assertEquals(todos.get(1), result.get(1));
        assertEquals(todos.get(2), result.get(2));
    }

    /**
     * Test of filterTitleByPhrase method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testFilterTitleByPhrase() {
        System.out.println("filterTitleByPhrase");
        String phrase = "inż";
        
        List<Todo> result = TodoController.getInstance().filterTitleByPhrase(phrase);
        assertTrue(result.contains(todos.get(0)));
        assertTrue(result.contains(todos.get(1)));
        assertFalse(result.contains(todos.get(2)));
    }

    /**
     * Test of filterCategoryByPhrase method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testFilterCategoryByPhrase() {
        System.out.println("filterCategoryByPhrase");
        String phrase = "z";
        
        List<Todo> result = TodoController.getInstance().filterCategoryByPhrase(phrase);
        assertTrue(result.contains(todos.get(0)));
        assertTrue(result.contains(todos.get(1)));
        assertFalse(result.contains(todos.get(2)));
    }

    /**
     * Test of filterByDate method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testFilterByDate() {
        System.out.println("filterByDate");
        Date date = new Date(2020, 11, 20);
        
        List<Todo> result = TodoController.getInstance().filterByDate(date);
        assertTrue(result.contains(todos.get(0)));
        assertTrue(result.size() == 1);
    }

    /**
     * Test of filterByIsImportant method, of class TodoController.
     */
    @org.junit.jupiter.api.Test
    public void testFilterByIsImportant() {
        System.out.println("filterByIsImportant");
        boolean isImportant = true;

        List<Todo> result = TodoController.getInstance().filterByIsImportant(isImportant);;
        assertTrue(result.contains(todos.get(0)));
        assertTrue(result.size() == 1);
    }
}
