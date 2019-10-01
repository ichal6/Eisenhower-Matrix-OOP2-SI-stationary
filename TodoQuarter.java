import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TodoQuarter{
    private ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();

    TodoQuarter(){

    }

    public void addItem(String title, LocalDate deadLine){
        //Append new item to List
        TodoItem newItem = new TodoItem(title, deadLine);
        todoItems.add(newItem);
        todoItems.sort(new DeadLine());
    }

    public void removeItem(int index){
        //Remove object with index from list
        todoItems.remove(index);
    }

    public void archiveItems(){
        //Remove all object with parametr isDone == true from list
    }

    public TodoItem getItem(int index){
        TodoItem object = todoItems.get(index);
        return object;
    }

    public List<TodoItem> getItems(){ 
        //Return private field todoItems - It's uncertain
        return todoItems;
    }

    public String toString(){
        // Return formatted list to label 
        String forString = "";
        return forString;
    }
}