/*
 * Circular queue using array of String
 */
public class CircularQueue {

	private String queue[];
	private int front, rear, capacity, count;

	/*
	 * initially front and rear are pointing to last element of array
	 */
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		queue = new String[capacity];
		front = 0;
		rear = capacity - 1;
		count = 0;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return (count == capacity);
	}

	/*
	 * inserts an element to the rear of circular queue
	 */
	public void insert(String item) {
		if (isFull()) {
			System.out.println("queue overflow");
		} else {
			// if queue is not full, find the position where item is to be
			// inserted in circular fashion
			rear = (rear == capacity - 1 ? 0 : rear + 1);
			queue[rear] = item;
			count++;
		}
	}

	/*
	 * removes an element from end of queue if it is not empty
	 */
	public String remove() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return null;
		} else {
			// if the queue is not empty, find the position from where the item
			// is to be removed in circular fashion
			String item = queue[front];
			front = (front == capacity - 1 ? 0 : front + 1);
			count--;
			return item;
		}
	}

	/*
	 * returns # of items in queue
	 */
	public int size() {
		return count;
	}

	/*
	 * prints the queue in circular fashion
	 */
	public void display() {
		if (isEmpty()) {
			System.out.println("queue is empty");
		} else {
			int start = front;
			int end = rear;

			// queue is linear at the moment
			if (start <= end) {
				for (int i = start; i <= end; i++)
					System.out.println(queue[i]);
			} else {
				// queue is circular
				for (int i = start; i < capacity; i++)
					System.out.println(queue[i]);

				for (int i = 0; i <= end; i++)
					System.out.println(queue[i]);

			}

		}
	}
}
