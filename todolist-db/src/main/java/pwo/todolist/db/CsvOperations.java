package pwo.todolist.db;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import pwo.todolist.engine.Todo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CsvOperations {

    public void toFile(List<Todo> todos) throws IOException {
        File csvOutputFile = new File("todos.csv");

        List<Todo> list = todos;

        //List<String> modifiedList = new ArrayList<>();

        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("title")
                .addColumn("category")
                .addColumn("date")
                .addColumn("isImportant")
                .addColumn("")
                .build();

        ObjectWriter writer = mapper.writerFor(Todo.class).with(schema);

        writer.writeValues(csvOutputFile).writeAll(list);
    }

    public static List<Todo> readTodosFromCSV() {

        List<Todo> todos = new ArrayList<>();
        Path pathToFile = Paths.get("todos.csv");

        try (BufferedReader br = Files.newBufferedReader(pathToFile, Charset.forName("UTF-8"))) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Todo todo = createTodo(attributes);

                todos.add(todo);

                line = br.readLine();
            }

        } catch (IOException | ParseException ioe) {
            ioe.printStackTrace();
        }

        return todos;
    }

    private static Todo createTodo(String[] metadata) throws ParseException {
        String title = metadata[0];
        String category = metadata[1];
        String date = metadata[2];
        String isImportant = metadata[3];

        Date data = new SimpleDateFormat("yyyy/MM/dd").parse(date);

        boolean b1 = Boolean.parseBoolean(isImportant);

        return new Todo(title, category, data, b1);
    }

}
