package Test.TestToDo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Main.ToDoList.Task;
import Main.ToDoList.ToDoMethods;

class TestToDoMethods {
	ToDoMethods methods = new ToDoMethods();
	List<Task> taskList = new ArrayList<>();

	@Test
	public void testAddTask() {
		methods.addTask();
		assertEquals(1, taskList.size());

	}

}
