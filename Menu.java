import java.util.Scanner;

public class Menu {
    Menu(){

    }
    public void displayMenu(){
        int numberOfOption = chooseOption();
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

    private void switchOptions(int numberOfOption){
        switch(numberOfOption){
            case 1:
                displayQuarter();
                break;
        }
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

    private void displayQuarter(){
        System.out.println("Please choose which one quarter to display:[NN,IN,IU,NU]");
        String answer = inputUserData();
        switch(answer){
            case "NN":
                break;
            case "IN":
                break;
            case "IU":
                break;
            case "NU":
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
}