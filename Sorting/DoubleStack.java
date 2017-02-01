import java.util.ArrayList;

public class DoubleStack {

	private ArrayList<Double> stack;
	private int capacity;

	/*
	 * Stack with limited capacity can be created
	 */
	public DoubleStack(int capacity) {
		this.capacity = capacity;
		this.stack = new ArrayList<Double>();
	}

	public boolean isEmpty() {
		return (stack.size() == 0);
	}

	/*
	 * returns an Double object
	 */
	public Double pop() {
		if (this.isEmpty()) {
			System.out.println("satck is empty");
			return null;
		} else {
			Double item = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return item;
		}
	}

	/*
	 * returns true if push operation was successful
	 */
	public int push(double item) {
		if (stack.size() == capacity) {
			System.out.println("Stack is full");
			return -1;
		} else {
			stack.add(item);
			return 1;
		}
	}
}
