/*
 * Stack using ArrayList
 */
import java.util.*;

public class MyStack {

	private ArrayList<Integer> stack;
	private int capacity;
	
	/*
	 * Stack with limited capacity can be created
	 */
	public MyStack(int capacity)
	{
		this.capacity = capacity;
		this.stack = new ArrayList<Integer>();
	}

	public boolean isEmpty() {
		return (stack.size() == 0);
	}

	/*
	 * returns an Integer object
	 */
	public Integer pop() {
		if (this.isEmpty()) {
			System.out.println("satck is empty");
			return null;
		} else {
			Integer item = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return item;
		}
	}
	
	/*
	 * returns true if push operation was successful
	 */
	public int push(int item)
	{
		if(stack.size() == capacity)
		{
			System.out.println("Stack is full");
			return -1;
		}
		else
		{
			stack.add(item);
			return 1;
		}		
	}
}
