package Test.TestToDo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Main.ToDoList.Task;

class TestTask {

	Task task = new Task();

	@Test
	void testSetGetTitle() {
		task.setTitle("Title1");
		assertEquals("Title1", task.getTitle());
	}

	void testSetGetProject() {
		task.setProject("Project1");
		assertEquals("Project1", task.getProject());
	}

	void testSetGetDueDate() {
		task.setDueDate("2020/05/29");
		;
		assertEquals("2020/05/29", task.getDueDate());
	}

	void testSetGetStatus() {
		task.setStatus("Started");
		;
		assertEquals("Started", task.getStatus());
	}
}
