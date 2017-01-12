/*
 * implementing circular linked list
 * last element points to first element
 */
public class CircularLinkedList {

	private Node last;

	public CircularLinkedList() {
		last = null;
	}

	public boolean isEmpty() {
		return (last == null);
	}

	/*
	 * insert element at end of list
	 */
	public void insertLast(int x) {

		Node item = new Node(x);

		if (isEmpty()) {
			last = item;
			last.next = last;
		} else {
			item.next = last.next;
			last.next = item;
			last = item;
		}
	}

	/*
	 * insert an element at the front on list
	 */
	public void insertFirst(int x) {
		Node item = new Node(x);

		if (isEmpty()) {
			last = item;
			last.next = last;
		} else {
			item.next = last.next;
			last.next = item;
		}
	}

	/*
	 * remove first element and return its data
	 */
	public int removeFirst() {
		if (isEmpty()) {
			System.out.println("list is empty");
			return -1;
		} else {
			int item;
			// only 1 element left
			if (last == last.next) {
				item = last.data;
				last = null;
			} else {
				item = last.next.data;
				last.next = last.next.next;
			}
			return item;
		}
	}

	/*
	 * remove last element from list and return its data
	 */
	public int removeLast() {
		if (isEmpty()) {
			System.out.println("list is empty");
			return -1;
		} else {
			int item;
			if (last == last.next) {
				item = last.data;
				last = null;
			} else {
				// find second last element
				Node temp = last.next;
				while (temp.next != last) {
					temp = temp.next;
				}
				item = last.data;
				temp.next = last.next;
				last = temp;
			}
			return item;
		}
	}

	/*
	 * display the contents of the list
	 */
	public void display() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			Node temp = last.next;
			while (temp != last) {
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
			System.out.println(last.data);
		}
	}

	public Node getList() {
		return last;
	}
}
