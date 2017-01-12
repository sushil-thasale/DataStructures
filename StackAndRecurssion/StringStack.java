/*
 * Stack using ArrayList
 */
import java.util.*;

public class StringStack {

	private ArrayList<String> stack;
	private int capacity;
	
	/*
	 * Stack with limited capacity can be created
	 */
	public StringStack(int capacity)
	{
		this.capacity = capacity;
		this.stack = new ArrayList<String>();
	}

	public boolean isEmpty() {
		return (stack.size() == 0);
	}

	/*
	 * returns an Integer object
	 */
	public String pop() {
		if (this.isEmpty()) {
			System.out.println("satck is empty");
			return null;
		} else {
			String item = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return item;
		}
	}
	
	/*
	 * returns true if push operation was successful
	 */
	public int push(String item)
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
	
	/*
	 * returns element at top of stack  
	 */
	public String stackTop()
	{
		if(isEmpty())
			return null;
		else
			return stack.get(stack.size()-1);		
	}
}
