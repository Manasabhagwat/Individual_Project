package Main.ToDoList;

import java.util.Scanner;

/**
 * Main class for user interface
 */
public class Main {
	// Instantiated ToDoMethods to use the methods
	static ToDoMethods methods = new ToDoMethods();

	// Scanner to get the user input
	static Scanner scanner = new Scanner(System.in);

	// StringBuilder to display the String List
	static StringBuilder strBuilder = new StringBuilder();

	public static void main(String[] args) throws Exception {

		// Loading the file
		methods.file();

		int input;
		strBuilder.append("Welcome to TODoLy \n");
		strBuilder.append(methods.displayTask());
		strBuilder.append("\nPick an option: \n");
		strBuilder.append("(1) Show Task List (by date or project) \n");
		strBuilder.append("(2) Add New Task \n");
		strBuilder.append("(3) Edit Task (update, mark as done, remove) \n");
		strBuilder.append("(4) Save and Quit \n");
		strBuilder.append("Option: ");
		System.out.println(strBuilder);
		input = scanner.nextInt();

		// Loop to select the options. Options selected by users
		switch (input) {
		case 1:
			System.out.println("Please Enter The Sort Option");
			System.out.println("(date) Sort by Date");
			System.out.println("(project) Sort by Project");
			String sortOption = scanner.next();
			methods.showList(sortOption);
			break;

		case 2:
			methods.addTask();
			break;

		case 3:
			editTask();
			break;

		case 4:
			methods.saveAndQuitTask();
			break;

		default:
			System.out.print("Please select a valid option\n");
			break;

		}

	}

	/*
	 * Methods to edit the task by updating, removing or marking the status as done
	 */

	public static void editTask() throws Exception {

		int editOption;

		do {
			System.out.println("please enter below edit options");
			System.out.println("(1) To Update the Task");
			System.out.println("(2) To Remove the Task");
			System.out.println("(3) To mark the Task as Done");
			System.out.println("(4) exit from edit option");
			editOption = scanner.nextInt();

			switch (editOption) {

			case 1:

				methods.updateTask();
				break;

			case 2:
				methods.removeTask();
				break;

			case 3:
				methods.markAsDone();
				break;

			case 4:
				System.out.println("exited from edit option");
				break;

			default:
				System.out.println("Please enter a valid option");
				break;

			}

		} while (editOption == 1 || editOption == 2 || editOption == 3 || !(editOption == 4));

	}

}
