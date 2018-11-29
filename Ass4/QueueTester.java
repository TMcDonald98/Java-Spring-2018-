/**
 * This program tests a queue and its subclass priority queue
 * CPSC 224-01, Spring 2018
 * Programming Assignment #4
 * @author Thomas McDonald
 * @version v1.0 2/23/18
 */
public class QueueTester {
	public static void main(String[] args) 
	{//MY MAX SIZE IS 6 IN THIS CASE
		Queue q = new Queue();
		PriorityQueue pQ = new PriorityQueue();
		//display
		q.display();
		pQ.display();
		//make tasks
		Task t1 = new Task(1,"Walk Dog");
		Task t2 = new Task(3,"Play Oboe");
		Task t3 = new Task(10,"HomeWork");
		Task t4 = new Task(7,"Eat");
		Task t5 = new Task(6,"Sleep");
		Task t6 = new Task(5,"Goto Class");
		Task t7 = new Task(2,"Take Out Trash");
		//add to q
		q.enqueue(t1); 
		q.enqueue(t4);
		q.enqueue(t2);
		q.enqueue(t7);
		q.enqueue(t5);
		q.enqueue(t4);
		q.enqueue(t3);
		q.enqueue(t6);
		//add to pQ
		pQ.enqueue(t4); 
		pQ.enqueue(t4);
		pQ.enqueue(t2);
		pQ.enqueue(t7);
		pQ.enqueue(t5);
		pQ.enqueue(t1);
		pQ.enqueue(t3);
		pQ.enqueue(t6);
		//display
		q.display();
		pQ.display();
		//dequque
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		//display
		q.display();
		pQ.display();
		//dequeue
		q.dequeue();
		q.dequeue();
		q.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		pQ.dequeue();
		//display
		q.display();
		pQ.display();
		//on empty
		pQ.dequeue();

	}

}
