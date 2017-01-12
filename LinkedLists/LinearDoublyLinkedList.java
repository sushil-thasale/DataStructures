/*
 * Node with left and right pointers
 */
class DoublyNode {
	public DoublyNode left, right;
	public int data;

	public DoublyNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

/*
 * implementing doubly linked list
 */
public class LinearDoublyLinkedList {

	private DoublyNode list;
	private int size;

	public LinearDoublyLinkedList() {
		list = null;
		size = 0;
	}

	/*
	 * returns true if empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * insert element at beginning of list
	 */
	public void insertFirst(int x) {
		DoublyNode item = new DoublyNode(x);

		if (list == null) {
			list = item;
		} else {
			item.right = list;
			list.left = item;
			list = item;
		}
		size++;
	}

	/*
	 * insert element at the end of list
	 */
	public void insertLast(int x) {
		DoublyNode item = new DoublyNode(x);
		if (list == null)
			list = item;
		else {
			DoublyNode temp = list;
			while (temp.right != null)
				temp = temp.right;

			temp.right = item;
			item.left = temp;
		}
		size++;
	}

	/*
	 * insert element at the specified position
	 */
	public void insertAt(int index, int x) {
		if (index < 0 || index > size)
			System.out.println("invalid index");
		else {
			if (index == 0)
				insertFirst(x);
			else if (index == size) {
				insertLast(x);
			} else {
				DoublyNode item = new DoublyNode(x);
				DoublyNode temp = list;
				for (int i = 0; i < index-1; i++)
					temp = temp.right;

				temp.right.left = item;
				item.right = temp.right;
				item.left = temp;
				temp.right = item;
			}
			size++;
		}
	}

	/*
	 * deleting first element if the list
	 */
	public void deleteFirst() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			if (size == 1 || list.right == null)
				list = null;
			else {
				list = list.right;
				list.left = null;
			}
			size--;
		}
	}

	/*
	 * delete last element of the list
	 */
	public void deleteLast() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			if (list.right == null)
				list = null;
			else {
				DoublyNode temp = list;
				while (temp.right.right != null)
					temp = temp.right;
				temp.right = null;
			}
			size--;
		}
	}

	/*
	 * delete element at the specified position
	 */
	public void deleteAt(int index) {
		if (isEmpty())
			System.out.println("list is empty");
		else if (index < 0 || index < size) {

			if (index == 0)
				deleteFirst();
			else if (index == size - 1)
				deleteLast();
			else {
				DoublyNode temp = list;
				for (int i = 0; i < index-1; i++)
					temp = temp.right;

				temp.right.right.left = temp;
				temp.right = temp.right.right;
			}
		} else
			System.out.println("not a valid index");

	}

	/*
	 * display the elements in the list
	 */
	public void display() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			DoublyNode temp = list;
			while (temp.right != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.right;
			}
			System.out.println(temp.data);
		}
	}
}
