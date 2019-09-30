package eisenhower;

import java.time.LocalDate;
public class TodoItem{
    String title;
    LocalDate deadline;
    boolean isDone = false;

    TodoItem(String title, LocalDate deadline){

    }

    private String getTitle(){
        //This method must be return title String
        return title;
    }

    private LocalDate getDeadline() {
        return deadline;
    }

    private void mark(){
        isDone = true;
    }

    private void unmark(){
        isDone = false;
    }

    public String toString(){
        String forString = "";
        return forString;
    }
}