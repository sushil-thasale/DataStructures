/*
 * Implementing stack using linked list operations
 */
public class StackUsingLinkedList {

	private Node top;
	private int size;
	private int capacity;

	public StackUsingLinkedList(int capacity) {
		top = null;
		size = 0;
		this.capacity = capacity;
	}

	/*
	 * pushes the given item on top on stack O(1) time
	 */
	public void push(int x) {
		if (isFull())
			System.out.println("Stack is full");
		else {
			Node item = new Node(x);
			item.next = top;
			top = item;
			size++;
		}
	}

	/*
	 * returns true if stack is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * returns true is stack is full
	 */
	public boolean isFull() {
		return (size == capacity);
	}

	/*
	 * returns stack top O(1) time
	 */
	public int pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			int item = stackTop();
			top = top.next;
			size--;
			return item;
		}
	}

	/*
	 * returns element at top of stack (doesn't remove that element)
	 */
	public int stackTop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			return top.data;
		}
	}

	/*
	 * prints the elements in stack
	 */
	public void display() {
		if (isEmpty())
			System.out.println("Stack is empty");
		else {
			Node temp = top;
			while (temp != null) {
				System.out.print(temp.data + " <- ");
				temp = temp.next;
			}
			System.out.println("bottom");
		}
	}
}
