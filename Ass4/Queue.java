//This class creates an object queue that can load at the back and 
//dequeue from the front using a linked list
public class Queue {
	protected static final int MAX_QUEUE = 6;
	//inner class for node struct
	public class Node <AnyType>{
		protected AnyType data;
		protected Node<AnyType> next;

	   public Node(AnyType data, Node<AnyType> next)
	   {
	      this.data = data;
	      this.next = next;
	   }
	   public Node(Node<AnyType> node)
	   {
		   this.data = node.data;
		   this.next = node.next;
	   }
	   
	}//protected for access in subclass
	protected Node<Task> front;
	protected Node<Task> back;
	protected int count;
	//initializes a new Queue with count 0
	public Queue()
	{
		count = 0;
	}
	/**
     * display neatly prints current queue (first in first out order)
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
		Node<Task> current = new Node<Task> (front);
		System.out.print("Queue: ");
		while(current.next != null)
		{
			System.out.print(current.data.getDescription() + ", ");
			current = new Node<Task> (current.next);
		}
		System.out.println(current.data.getDescription() + ".");
	}
	/**
     * enqueue adds a new task to the end of current queue
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
		else if(isEmpty())//special case required to handle front and back
		{
			front = new Node<Task>(newTask, null);
			back = front;
			count = 1;
		}
		else if(count == 1)//special case required to handle front and back
		{
			back = new Node<Task>(newTask, null);
			front.next = back;
			count = 2;
		}
		else
		{
			Node<Task> end = new Node<Task>(newTask, null);
			back.next = end;
			back = end;
			count++;
		}
	}
	/**
     * dequeue removes front most task in current queue and shifts
     *
     * @param N/A
     * @returns N/A
     * @throw N/A
     */
	public void dequeue()
	{
		if(isEmpty())//no statement needed but queue remains empty
			return;
		else
		{
			if(front.next == null)//special case to handle back
			{
				front = null;
				back = null;
			}
			else
			{
				front = front.next;
			}
			count--;
		}
	}
	/**
     * isFull simply compares queue count to max size and returns t/f
     *
     * @param N/A
     * @returns boolean whether queue is full or not
     * @throw N/A
     */
	public boolean isFull()
	{
		return count==MAX_QUEUE;
	}
	/**
     * isEmpty simply compares queue count to 0 and returns t/f
     *
     * @param N/A
     * @returns boolean whether queue is empty or not
     * @throw N/A
     */
	public boolean isEmpty()
	{
		return count==0;
	}
}
