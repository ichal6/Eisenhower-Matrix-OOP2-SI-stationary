import java.util.Comparator;
 
public class DeadLine implements Comparator<TodoItem>
{
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getDeadline().compareTo(o2.getDeadline());
    }
}