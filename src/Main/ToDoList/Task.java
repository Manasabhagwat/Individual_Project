package Main.ToDoList;

/**
 * @param title   - Title of the project
 * @param project - Name of the project
 * @param dueDate - Date to complete the project
 * @param status  - Status of the project
 *
 */
public class Task {
	private String title;
	private String project;
	private String dueDate;
	private String status;

	public Task() {

	}

	public Task(String title, String project, String dueDate, String status) {
		this.title = title;
		this.project = project;
		this.dueDate = dueDate;
		this.status = status;

	}

	/**
	 * Below methods to set and get the values of the attributes
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;

	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + " Project: " + this.project + " Due_Date: " + this.dueDate + " Status: "
				+ this.status;
	}

}
