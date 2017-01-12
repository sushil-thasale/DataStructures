/*
 * implementing 2 stack in one array
 */

public class TwoStacksInOneArray {

	private int array[];
	private int capacity;
	private int top1;
	private int top2;

	/*
	 * Stack with limited capacity can be created
	 */
	public TwoStacksInOneArray(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
		top1 = -1;
		top2 = capacity;
	}

	public boolean isStack1Empty() {
		return (top1 == -1);
	}

	public boolean isStack2Empty() {
		return (top2 == capacity);
	}

	/*
	 * pop from top of stack-1
	 */
	public Integer popStack1() {
		if (this.isStack1Empty()) {
			System.out.println("satck-1 is empty");
			return null;
		} else {
			return (new Integer(array[top1--]));
		}
	}

	/*
	 * pop from top of stack-2
	 */
	public Integer popStack2() {
		if (this.isStack2Empty()) {
			System.out.println("satck-2 is empty");
			return null;
		} else {
			return (new Integer(array[top2++]));
		}
	}

	/*
	 * push an item on stack-1
	 */
	public int pushStack1(int item) {
		if (top1 >= capacity - 1 || top1 + 1 >= top2) {
			System.out.println("Stack is full");
			return -1;
		} else {
			array[++top1] = item;
			return 1;
		}
	}

	/*
	 * push an item on stack-2
	 */
	public int pushStack2(int item) {
		if (top2 <= 0 || top2 - 1 <= top1 ) {
			System.out.println("Stack is full");
			return -1;
		} else {
			array[--top2] = item;
			return 1;
		}
	}

	/*
	 * returns element at top of stack-1
	 */
	public Integer stack1Top() {
		if (isStack1Empty())
			return null;
		else
			return (new Integer(array[top1]));
	}

	/*
	 * returns element at top of stack-2
	 */
	public Integer stack2Top() {
		if (isStack2Empty())
			return null;
		else
			return (new Integer(array[top2]));
	}
	
	/*
	 * print stack-1
	 */
	public void displayStack1()
	{
		for(int i = 0;i<=top1;i++)
			System.out.print(array[i]+" ");
		System.out.println(" <- top");
	}
	
	/*
	 * print stack-2
	 */
	public void displayStack2()
	{
		for(int i=capacity-1;i>=top2;i--)
			System.out.print(array[i]+" ");
		System.out.println(" <- top");
	}
}
