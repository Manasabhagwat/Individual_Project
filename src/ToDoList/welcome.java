package ToDoList;

import java.util.Scanner;

public class welcome {

	public static void main(String[] args) {
		System.out.println("Welcome to TODoLy");
		System.out.println("You have X tasks todo and Y tasks are done!");
		System.out.println("Pick an option:");
		System.out.println("(1) Show Task List (by date or project)");
		System.out.println("(2) Add New Task");
		System.out.println("(3) Edit Task (update, mark as done, remove)");
		System.out.println("(4) Save and Quit");
		
		//Scanner scanner = new Scanner (System.in);
		//String option = scanner.nextLine();
		
		//System.out.println("Your option is " + option);
		
		ToDoMethods tdm = new ToDoMethods();
		tdm.writeTask();
		//tdm.writeTaskToFile();
		//tdm.DisplayTask();
		
	}

}
