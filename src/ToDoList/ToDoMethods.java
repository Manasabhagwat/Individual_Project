package ToDoList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class ToDoMethods {
	private ArrayList<Task> taskList;

		 
	public ToDoMethods() {
	
	}
	public void writeTask() throws NullPointerException {
		try {
	
		{
			Scanner details = new Scanner (System.in);
			System.out.println("My Task Details");
			System.out.println("Title of my task: ");
			String title = details.nextLine();
			System.out.println("My Project name: ");
			String project = details.nextLine();
			System.out.println("Due date of my task: ");
			String dueDate = details.nextLine();
			System.out.println("status: ");
			String status = details.nextLine();
			Task task = new Task (title, project, dueDate, status);
			taskList.add(task);
			System.out.println("Your Task is: " + title + " under project " + project + " with due date " + dueDate + " and the status as" + status + " has been added to TaskList");						
				
		}
	}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		System.out.println("An error occured");
	}
		
	
	public void writeTaskToFile() {
		try {
			FileWriter filewrite = new FileWriter("/Users/manasabhagwat/Desktop/todo/list.txt");
			for(Task task : taskList) {
				
				filewrite.write("project: " + task.getProject() + " Title: " + task.getTitle() + " Due date" + task.getDuedate() + task.getStatus());
				
			}
			filewrite.close();
			System.out.println("Written to file Successfully");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	public void DisplayTask() {
		for(Task task : taskList) {
			Task done_task = task;
			Task todo_task = task;
			if(task.getStatus() == "done") {
				done_task = task;
			}
			else {
				todo_task = task;
			}
			System.out.println("Yoh have" + todo_task + "to do and " + done_task + "are done");
		}
		
		/*
		 * public void changeTask() { ListIterator<Task> itr = taskList.listIterator();
		 * 
		 * 
		 * 
		 * }
		 */
		
	}
	}
	