import java.util.*;
public class ToDoList {

    static Scanner scan = new Scanner(System.in);
    //String arrays to store tasks and dates
    static String[] tasks;
    static String[] dates;
    
    // limit variable to check if todolist is full or not
    static int limit;

    // static block to initializing static variables for proper usage
    static{
        tasks = new String[50];
        dates = new String[50];
        limit = 0;
    }

    //method to add task
    static void addTask(){
        System.out.print("Enter Task Name : ");
        try {
            String task = scan.nextLine();
            System.out.println("Date Format : 22-1-2025");
            System.out.print("Enter Task Date : ");
            String task_date = scan.nextLine();
            tasks[limit] = task;
            dates[limit] = task_date;
            limit++;
        }
        catch (ArrayIndexOutOfBoundsException error){
            System.out.println("Task List Full");
        }
        catch (Exception error){
            System.out.println("> Error" + error);
        }

    }
    //method to remove task
    static void removeTask(){
        System.out.print("Enter Task Name :");
        try {
            String remove_task = scan.nextLine();
            int remove_index = 0;
            for (String task : tasks) {
                if (remove_task.equals(task)) {
                    tasks[remove_index] = null;
                    dates[remove_index] = null;
                    System.out.println("Task Removed");
                }
                remove_index++;
            }
        }
        catch (Exception e){
            System.out.println("Error : " + e);
        }
    }
    // method to show user todolist
    static void showToDoList(){

        try {
            int date_index = 0;
            System.out.println("> To Do List");
            for (String task : tasks) {

                if(task != (null)){
                    System.out.println("Task Name :"+ task + "> Date :" + dates[date_index] );
                }
                date_index++;
            }
            System.out.println();
        }
        catch(NullPointerException e){
            System.out.println("Error : " + e.getMessage());
        }

    }
    //show menu method
    static void showMenu(){
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println(("3. Show ToDoList"));
        System.out.println("4. Exit");

    }
    // main method
    public static void main(String[] args){

        // boolean run variable for deciding start and end of  todolist
        boolean run = true;
        while(run){

            showMenu();
            System.out.print("> Enter Selection : ");
            String select = scan.nextLine();

            try{
                int choice = Integer.parseInt(select);

                switch(choice){
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        showToDoList();
                        break;
                    case 4:
                        run = false;
                        break;
                    default:
                        System.out.println("> Provide Valid Selection");
                        break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("> Selection Cannot be Non-Numeric");
            }
            catch (Exception e){
                System.out.println("Error : " + e);
            }
        }

    }
}
