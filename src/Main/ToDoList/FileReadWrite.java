package Main.ToDoList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class is providing the file details to store the tasks entered by the
 * user This class consisting of 2 methods one is to read the file And other one
 * is to write into the file
 */

public class FileReadWrite {
	/**
	 * Passing the file path as string
	 */
	String file = "list.txt";

	/**
	 * Method to read the file and parse the values for the attributes in Task class
	 */
	public List<Task> readFile(List<Task> taskList) {

		try {
			BufferedReader fileRead = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileRead.readLine()) != null) {
				String[] tempTask = line.split(" ");
				Task setValues = new Task();
				setValues.setTitle(tempTask[1]);
				setValues.setProject(tempTask[3]);
				setValues.setDueDate(tempTask[5]);
				setValues.setStatus(tempTask[7]);
				taskList.add(setValues);

			}

			fileRead.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(
					"Check your text file. It might be empty.. \nIf not, check your error\n----------------------------------------");
		}
		return taskList;

	}

	/*
	 * Method to write into the file for each task in taskList
	 */

	public void writeTaskToFile(List<Task> taskList) {
		try {
			BufferedWriter filewrite = new BufferedWriter(new FileWriter(file));
			for (Task task : taskList) {

				filewrite.write("Title: " + task.getTitle() + " Project: " + task.getProject() + " Due_Date: "
						+ task.getDueDate() + " Status: " + task.getStatus());
				filewrite.newLine();
			}
			filewrite.close();
			System.out.println("File Updated Successfully");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
