public class PriorityQueue extends Queue {
	public PriorityQueue()
	{
		count = 0;
	}
	/**
     * display neatly prints current queue and the priorities 
     * (first in first out order)
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return;
		}
		Node<Task> current = front;
		System.out.print("Priority Queue: ");
		while(current.next != null)//until only one element remains
		{
			System.out.print("(" + current.data.getPriority() + ", " 
			+ current.data.getDescription()+ "), ");
			current = current.next;
		}
		System.out.println("("+current.data.getPriority() +", " //last element
		+ current.data.getDescription() +").");
	}
	/**
     * enqueue adds a new task taking into account the priority of Task
     *
     * @param newTask a new task to be added to the queue
     * @returns N/A
     * @throw N/A
     */
	public void enqueue(Task newTask)
	{
		if(isFull())
		{
			System.out.println("Sorry Queue is Full");
			return;
		}
		else if(isEmpty())
		{
			front = new Node<Task>(newTask, null);
			back = front;
			count = 1;
		}
		else if(count == 1)//special case to handle front and back
		{
			if(newTask.getPriority() <= front.data.getPriority())
			{
				back = new Node<Task>(newTask, null);
				front.next = back;
			}
			else
			{
				back = front;
				front = new Node<Task> (newTask, back);
			}
			count = 2;
		}
		else
		{
			Node<Task> newT = new Node<Task>(newTask, null);
			if(newT.data.getPriority() >= front.data.getPriority())
				//handles case where newTask has highest priority
			{
				front = new Node<Task>(newTask,front);
			}
			else if(newT.data.getPriority() < back.data.getPriority())
				//handles case where newTask has lowest priority
			{
				back.next = newT;
				back = newT;
			}
			else//all other cases
			{
				Node<Task> temp = front;
				while(temp.next != null)//took care of last element above
				{
					if(newT.data.getPriority() >= temp.next.data.getPriority())
					{
						newT.next = temp.next;
						temp.next = new Node<Task>(newT);
						break;
					}
					else
						temp = temp.next;
				}
			}
			count++;
		}
	}
}
