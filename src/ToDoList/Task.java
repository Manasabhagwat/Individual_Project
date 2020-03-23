package ToDoList;

public class Task {
	private String project;
	private String title;
	private String duedate;
	private String status;
	
	public Task() {
		
	}
	
	public Task(String title, String project, String duedate, String status) {
		this.title = title;
		this.duedate = duedate;
		this.status = status;
		this.project = project;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	/*public String getStatus() {
		String current_status = "";
		if(this.status == true) {
			current_status = "has completed";
		}
		else {
			current_status = "is not completed";
		}
		return current_status;
	}*/
	
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
	
		
	
}
