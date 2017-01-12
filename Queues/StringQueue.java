import java.util.ArrayList;

/*
 * queue using arraylist
 */
public class StringQueue {

	private ArrayList<String> queue;
	private int capacity;

	
	// specify the capacity of queue
	public StringQueue(int capacity) {
		this.capacity = capacity;
		queue = new ArrayList<String>();
	}

	// returns true if queue is empty
	public boolean isEmpty() {
		return (queue.size() == 0);
	}

	// add an element at end of queue
	public int insert(String item) {
		if (queue.size() == capacity) {
			System.out.println("queue overfl]ow");
			return -1;
		} else {
			queue.add(item);
			return 1;
		}
	}

	// remove element from front of queue
	public String remove() {
		if (isEmpty())
			return null;
		else {
			String item = queue.get(0);
			queue.remove(0);
			return item;
		}
	}
}
