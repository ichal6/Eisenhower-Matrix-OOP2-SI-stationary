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
        try{
            todoItems.remove(index);
        }
        catch(Exception e){
            System.out.println("Wrong index! Nothing is erase.");
        }
    }

    public void archiveItems(){
        //Remove all object with parametr isDone == true from list
        int arrayLength = todoItems.size();
        for(int index = 0; index < arrayLength; index++){
            TodoItem item = todoItems.get(index);
            if(item.isDone()){
                todoItems.remove(item);
                arrayLength--;
            }
        }
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
        String outputString = "";
        String row = "";
        for (int index = 1; index <= todoItems.size(); index++)
        {
            row = todoItems.get(index-1).toString();
            outputString += String.format("%d. %s\n", index, row);
        }
        return outputString;
    }
}