package Main.ToDoList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ToDoMethods {
	private List<Task> taskList = new ArrayList<Task>();
	Scanner details = new Scanner(System.in);
	FileReadWrite filing = new FileReadWrite();

	public ToDoMethods() {

	}

	/**
	 * This method helps to print all tasks from the tasks list It will sort
	 * according to user interest sort by project or sort by date
	 * 
	 */
	public void showList(String sortOption) {

		String sortOpt = sortOption.toLowerCase();

		if (sortOpt.equals("date")) {
			taskList = taskList.stream().sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
		} else if (sortOpt.equals("project")) {
			taskList = taskList.stream().sorted(Comparator.comparing(Task::getProject)).collect(Collectors.toList());
		} else {
			System.out.println("Invalid sort option");
		}

		if (taskList.size() == 0) {
			System.out.println("List is Empty!");
		} else {
			for (Task task : taskList) {
				System.out.println(task.toString());
			}
		}
	}

	/**
	 * This method add new task to the taskList values set by users
	 * 
	 */

	public void addTask() throws NullPointerException {
		try {

			{

				System.out.println("My Task Details");
				System.out.println("Title of my task: ");
				String title = details.nextLine();
				System.out.println("My Project name: ");
				String project = details.nextLine();
				System.out.println("Due date of my task(YYYY/MM/DD): ");
				String dueDate = details.nextLine();
				System.out.println("Please enter your status");
				String status = details.nextLine();

				Task task = new Task(title, project, dueDate, status);

				taskList.add(task);
				System.out.println("Your Task is: " + title + " under project: " + project + " with due_date: "
						+ dueDate + " and the status as: " + status + " has been added to your ToDo List");
				filing.writeTaskToFile(taskList);
			}
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("An error occured");
		}
	}

	/**
	 * Method to display number of Done tasks and open tasks
	 */
	public String displayTask() {
		int countX = 0;
		int countY = 0;
		for (Task task : taskList) {
			if (task.getStatus().equals("Done")) {
				countY++;
			} else {
				countX++;
			}
		}

		return "You have " + countX + " tasks todo and " + countY + " tasks are done!";

	}

	/**
	 * Method to update the task and the task selected by the user by title
	 */
	public void updateTask() {
		displayForEdit();
		boolean taskFound = false;
		System.out.println("Please enter a title of a task to update");
		System.out.println("Title: ");
		String updateTaskTitle = details.next();

		if (updateTaskTitle != null) {

			System.out.println("Please enter new title:");
			String newTitle = details.next();
			System.out.println("Please enter new dueDate  as yyyy-mm-dd:");
			String newDueDate = details.next();
			System.out.println("Please enter new Project name:");
			String newProject = details.next();

			for (Task t : taskList) {

				if ((t.getTitle()).equals(updateTaskTitle)) {
					t.setTitle(newTitle);
					t.setDueDate(newDueDate);
					t.setProject(newProject);
				}
			}
			taskFound = true;
			System.out.println("Your task has been updated successfully:");
			filing.writeTaskToFile(taskList);

		} else {

			System.out.println("Please select a valid Task");
		}
		if (taskFound == false) {

			System.out.println("Task not found!" + "\n");

		}
	}

	/**
	 * Method to update the task status as done. Task selected by the user by title
	 */
	public void markAsDone() {
		displayForEdit();
		System.out.println("Please enter a title of a task to mark as done");
		System.out.println("Title: ");
		String taskToMarkAsDone = details.next();

		if (taskToMarkAsDone != null) {
			for (Task t : taskList) {

				if (t.getTitle().equals(taskToMarkAsDone)) {
					if (t.getStatus() != "Done") {
						t.setStatus("Done");
						filing.writeTaskToFile(taskList);

					} else {
						System.out.println("The status is already done");
					}
				}
			}

		} else {
			System.out.println("Please select a valid Task");
		}

	}

	/**
	 * Method to remove the task and task selected by the user by title
	 */
	public void removeTask() {
		displayForEdit();
		boolean taskFound = false;
		System.out.println("Please enter a title of a task to remove");
		System.out.println("Title: ");
		String deleteTaskTitle = details.next();

		if (deleteTaskTitle != null) {

			taskList.removeIf(t -> deleteTaskTitle.equals(t.getTitle()));
			taskFound = true;
			System.out.println("Your task has been removed from the list");
			filing.writeTaskToFile(taskList);

		} else {
			System.out.println("Please select a valid Task");
		}

		if (taskFound == false) {

			System.out.println("Your Task not found!" + "\n");

		}
	}

	/**
	 * Method to load the file
	 */
	public void file() {
		taskList = filing.readFile(taskList);
	}

	/**
	 * Method to write changes to file before leaving the system
	 */
	public void saveAndQuitTask() {
		filing.writeTaskToFile(taskList);
		System.out.println("Saved all all your changes successfully...");
	}

	public void displayForEdit() {
		System.out.println("Below are the tasks in your List");
		for (Task task : taskList) {
			System.out.println(task.toString());

		}
	}

}
