import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private TodoMatrix matrix = new TodoMatrix();

    Menu(){
        matrix.addItemsFromFile("todo_items_read_test.csv");
    }

    public void displayMenu(){
        boolean isRun = true;
        while(isRun){
            int numberOfOption = chooseOption();
            isRun = switchOptions(numberOfOption);
        }
        
    }

    private void displayOptions(){
        String[] options =  {"1. Show quarter matrix", "2. Add item to matrix",
                            "3. Mark or unmark your tasks", "4. Remove items from matrix",
                            "5. Remove all done items", "6. Save to file items",
                            "7. Remove all done items, save to file and close program",
                            "8. Show all matrix", "0. Close program"};
        for(String option: options){
           System.out.println(option); 
        }
    }

    private boolean switchOptions(int numberOfOption){
        switch(numberOfOption){
            case 1:
                displayQuarter();
                break;
            case 2:
                addItem();
                break;
            case 3:
                String status = displayQuarter();
                if(status.equals("emptyQuarter")){
                    System.out.println("Quarter is empty!");
                    break;
                }
                int indexItem = selectItem();
                if( matrix.getQuarter(status).getItem(indexItem).isDone()){
                    matrix.getQuarter(status).getItem(indexItem).unmark();
                }
                else{
                    matrix.getQuarter(status).getItem(indexItem).mark();
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 0:
                return false;
        }
        return true;
    }

    private int chooseOption(){
        int numberOfOption = 0;
        boolean isInsert = true;
        while(isInsert){
            displayOptions();
            System.out.println("Please choose option:");
            try{
                numberOfOption = Integer.parseInt(inputUserData());
                isInsert = false;
                
            }catch(Exception e){
                System.out.println("Incorrect value!");
                isInsert = true;
            }
        }
        return numberOfOption;
    }

    private String inputUserData(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    private String displayQuarter(){
        System.out.println("Please choose which one quarter to display:[NN,IN,IU,NU]");
        String answer = inputUserData();
        switch(answer){
            case "NN":
            case "IN":
            case "IU":
            case "NU":
                System.out.println(matrix.getQuarter(answer).toString());
                String unconvertData = matrix.getQuarter(answer).toString().toString();
                if(unconvertData.equals("")){
                    return answer = "emptyQuarter";
                }
                return answer;
            default:
                System.out.println("Wrong input!");
        }
        
        return answer = "emptyQuarter";
    }

    private void addItem(){
        System.out.print("Please insert title item: ");
        String title = inputUserData();
        int monthAsInt = 1, dayAsInt = 1;
        boolean isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print("Please insert month deadline: ");
                String month = inputUserData();
                monthAsInt = Integer.parseInt(month);
                if (monthAsInt > 0 & monthAsInt < 13){
                    isNotCorrect = false;
                }
                else{
                    System.out.println("Please insert correct month!");
                }
            }
            catch (Exception e){
                System.out.println("Please insert correct month!");
            }
        }
        isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print("Please insert day deadline: ");
                String day = inputUserData();
                dayAsInt = Integer.parseInt(day);
                if (dayAsInt > 0 & dayAsInt < 32){
                    isNotCorrect = false;
                }
                else{
                    System.out.println("Please insert correct day!");
                }
            }
            catch (Exception e){
                System.out.println("Please insert correct day!");
            }
        }
        LocalDate deadline = LocalDate.now();
        int actualYear = deadline.getYear();
        deadline = deadline.of(actualYear, monthAsInt, dayAsInt);

        System.out.print("Is your task important?:[y] ");
        String answer = inputUserData();
        if(answer.contains("y"))
        {
            matrix.addItem(title, deadline, true);
        }
        else{
            matrix.addItem(title, deadline);
        }
    }

    private int selectItem(){
        int index = 0;
        boolean isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print("Please select item by mark/unmark: ");
                index = Integer.parseInt(inputUserData());
                isNotCorrect = false;
            }catch(Exception e){
                System.out.println("Wrong input!");
            }
        }
        return index - 1;
    }
}