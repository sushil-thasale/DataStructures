import java.util.*;

/*
 * Simple linked list
 */
public class DynamicLinkedList {

	private Node list;
	private int size;

	public DynamicLinkedList() {
		list = null;
		size = 0;
	}

	/*
	 * inserts an element at beginning of list
	 */
	public void insertFirst(int x) {
		Node item = new Node(x);

		if (list == null)
			list = item;
		else {
			item.next = list;
			list = item;
		}

		size++;
	}

	/*
	 * inserts an element at the end of the list
	 */
	public void insertLast(int x) {
		Node item = new Node(x);

		if (list == null)
			list = item;
		else {
			Node temp = list;
			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = item;
		}
		size++;
	}

	/*
	 * insert an element at the given position
	 */
	public void insertAt(int index, int element) {
		if (index >= 0 && index <= size) {

			if (index == 0)
				insertFirst(element);
			else {
				Node item = new Node(element);
				Node temp = list;

				for (int i = 0; i < index - 1; i++)
					temp = temp.next;

				item.next = temp.next;
				temp.next = item;
				size++;
			}
		} else {
			System.out.println(index
					+ " : Not a valid index. Current size is :" + size);
		}
	}

	/*
	 * delete an element from beginning of list
	 */
	public void deleteFirst() {

		if (list == null)
			System.out.println("list is empty");
		else {
			list = list.next;
			size--;
		}
	}

	/*
	 * deletes element at end of the list
	 */
	public void deleteLast() {
		if (list == null)
			System.out.println("list is empty");
		else {
			Node temp = list;
			Node prevtemp = null;

			while (temp.next != null) {
				prevtemp = temp;
				temp = temp.next;
			}

			prevtemp.next = null;
			size--;
		}
	}

	/*
	 * delete an element at the given index
	 */
	public void deleteAt(int index) {
		if (index >= 0 && index <= size - 1) {
			if (index == 0)
				deleteFirst();
			else {
				Node temp = list;
				Node prevTemp = null;

				for (int i = 0; i < index; i++) {
					prevTemp = temp;
					temp = temp.next;
				}

				prevTemp.next = temp.next;
				size--;
			}

		} else {
			System.out.println(index + " : Invalid index");
		}
	}

	/*
	 * displays the content of the list
	 */
	public void display() {
		if (list == null)
			System.out.println("list is empty");
		else {
			Node temp = list;
			while (temp != null) {
				System.out.print(temp.data);
				temp = temp.next;
				if (temp != null)
					System.out.print(" -> ");
			}
			System.out.println();
		}
	}

	public Node getList() {
		return list;
	}

	public void setList(Node list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * append this linked list with given linked list
	 */
	public void append(DynamicLinkedList l) {
		if (this.list == null)
			list = l.clone().getList();
		else {

			Node newList = l.clone().getList();
			Node temp = list;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newList;
		}
	}

	/*
	 * copy linked list object
	 */
	public DynamicLinkedList clone() {
		Node newList = new Node(0);
		Node newListTemp = newList;

		Node temp = list;
		while (temp != null) {
			Node item = new Node(temp.data);
			newListTemp.next = item;
			temp = temp.next;
			newListTemp = newListTemp.next;
		}

		DynamicLinkedList d = new DynamicLinkedList();
		d.setList(newList);
		d.deleteFirst();
		d.setSize(size);
		return d;
	}

	/*
	 * merge two sorted linked list
	 */
	public static DynamicLinkedList merge(DynamicLinkedList l1,
			DynamicLinkedList l2) {
		Node list1 = l1.clone().getList();
		int size1 = l1.getSize();

		Node list2 = l2.clone().getList();
		int size2 = l2.getSize();

		Node mainList = new Node(0);
		Node mergedList = mainList;

		// copy smaller # into merged list
		while (list1 != null && list2 != null) {
			Node item;
			if (list1.data <= list2.data) {
				item = new Node(list1.data);
				list1 = list1.next;
			} else {
				item = new Node(list2.data);
				list2 = list2.next;
			}
			mergedList.next = item;
			mergedList = mergedList.next;
		}

		// copy left over from list2
		if (list1 == null) {
			while (list2 != null) {
				Node item = new Node(list2.data);
				mergedList.next = item;
				list2 = list2.next;
				mergedList = mergedList.next;
			}
		}

		// copy left over from list1
		if (list2 == null) {
			while (list1 != null) {
				Node item = new Node(list1.data);
				mergedList.next = item;
				list1 = list1.next;
				mergedList = mergedList.next;
			}
		}

		DynamicLinkedList d = new DynamicLinkedList();
		d.setList(mainList);
		d.deleteFirst();
		d.setSize(size1 + size2);

		return d;
	}

	/*
	 * reverse a linked list using another list
	 */
	public void reverse1() {
		Node reverseList = null;
		while (list != null) {
			Node item = new Node(list.data);
			if (reverseList == null)
				reverseList = item;
			else {
				item.next = reverseList;
				reverseList = item;
			}
			list = list.next;
		}
		list = reverseList;
	}

	/*
	 * reverse a linked list without using another list
	 */
	public void reverse2() {
		Node previousNode = null;
		Node nextNode = null;
		Node currentNode = list;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		list = previousNode;
	}

	/*
	 * print intersection of two linked lists
	 */
	public void printIntersection(DynamicLinkedList list2) {
		HashMap<Integer, Integer> presence = new HashMap<Integer, Integer>();
		Node temp = list2.getList();

		while (temp != null) {
			presence.put(temp.data, 1);
			temp = temp.next;
		}

		temp = list;
		while (temp != null) {
			if (presence.containsKey(temp.data))
				System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
