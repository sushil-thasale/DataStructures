/*
 * implementing queue using linked list
 */
public class QueueUsingLinkedList {

	private Node front, rear;
	private int capacity;
	private int size;

	public QueueUsingLinkedList(int capacity) {
		this.capacity = capacity;
		size = 0;
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == capacity);
	}

	/*
	 * insert element at the end of queue
	 */
	public void insert(int x) {
		if (isFull())
			System.out.println("Queue is full");
		else {
			Node item = new Node(x);
			if (isEmpty()) {
				front = item;
				rear = item;
			} else {
				rear.next = item;
				rear = item;
			}
			size++;
		}
	}

	/*
	 * remove element from front of queue
	 */
	public int remove() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		} else {
			int item;
			// only element in list
			if (front == rear) {
				item = front.data;
				front = null;
				rear = null;
			} else {
				item = front.data;
				front = front.next;
			}
			size--;
			return item;
		}
	}

	/*
	 * print the contents of queue
	 */
	public void display() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			Node temp = front;
			while (temp != null) {
				System.out.println(temp.data + "\t");
				temp = temp.next;
			}
		}
	}
}
