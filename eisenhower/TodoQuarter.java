package eisenhower;

import java.time.LocalDate;
import java.util.ArrayList;
public class TodoQuarter{
    ArrayList<String> toDoItems = new ArrayList<String>();

    TodoQuarter(){

    }

    private void addItem(String title, LocalDate deadLine){
        //Append new item to List
    }

    private void removeItem(int index){
        //Remove object with index from list
    }

    private void archiveItems(){
        //Remove all object with parametr isDone == true from list
    }

    private String getItem(int index){
        String object = "";
        return object;
    }

    private void/*uncertain return type */ getItems(){ 
        //Return private field todoItems - It's uncertain
    }

    public String toString(){
        // Return formatted list to label 
        String forString = "";
        return forString;
    }
}