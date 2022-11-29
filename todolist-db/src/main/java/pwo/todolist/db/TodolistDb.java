package pwo.todolist.db;

import pwo.todolist.engine.Todo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Patryk
 */
public class TodolistDb {

    public static void main(String[] args) throws IOException {
        CsvOperations csvOperations = new CsvOperations();

        List<Todo> todos = new ArrayList<>();

        Date date1 = new Date(2020, 11, 20, 13, 12, 44);
        Todo todo1 = new Todo("Nie robić inżynierki", "Zabawa", date1, true);
        Date date2 = new Date(2020, 11, 21, 13, 12, 44);
        Todo todo2 = new Todo("Zrobić inżynierkę", "Szkoła", date2, false);
        Date date3 = new Date(2020, 11, 19, 13, 12, 44);
        Todo todo3 = new Todo("Ale co robić", "Relaks", date3, false);

        System.out.println(date1);
        System.out.println(date1);


        //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(todo1.date));

        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);

        csvOperations.toFile(todos);

        //List<Todo> wczytaj = new ArrayList<>();
        //wczytaj = csvOperations.readTodosFromCSV();
        //System.out.println(wczytaj);
    }
}
