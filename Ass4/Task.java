//Task is an object that simply contains a priority number and a task description
public class Task {
	private String taskDescription;
	private int taskPriority;
	//creates a new task given its priority and description
	public Task(int priority, String description)
	{
		taskPriority = priority;
		taskDescription = description;
	}
	/**
     * returns description
     *
     * @param N/A
     * @returns String description
     * @throw N/A
     */
	public String getDescription()
	{
		return taskDescription;
	}
	/**
     * returns priority
     *
     * @param N/A
     * @returns int priority
     * @throw N/A
     */
	public int getPriority()
	{
		return taskPriority;
	}
	/**
     * sets a description
     *
     * @param description string
     * @returns N/A
     * @throw N/A
     */
	public void setDescription(String description)
	{
		taskDescription = description;
	}
	/**
     * sets a Priority
     *
     * @param priority int 
     * @returns N/A
     * @throw N/A
     */
	public void setPriority(int priority)
	{
		taskPriority = priority;
	}
}
