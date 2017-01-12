public class TestCode {

	public static void main(String args[]) {

		// DynamicLinkedList list = new DynamicLinkedList();
		//
		// list.insertFirst(0);
		// list.display();
		//
		// list.insertFirst(1);
		// list.display();
		//
		// list.insertLast(2);
		// list.display();
		//
		// list.insertLast(3);
		// list.display();
		//
		// list.insertAt(2, 4);
		// list.display();
		//
		// list.deleteFirst();
		// list.display();
		//
		// list.deleteLast();
		// list.display();
		//
		// list.deleteAt(0);
		// list.display();

		// QueueUsingLinkedList s = new QueueUsingLinkedList(5);
		// for(int i=0;i<=5;i++)
		// s.insert(i);
		// s.display();
		// for(int i =0;i<=5;i++)
		// System.out.println(s.remove());

		// CircularLinkedList c = new CircularLinkedList();
		// c.insertFirst(1);
		// c.display();
		//
		// c.insertLast(2);
		// c.display();
		//
		// c.insertLast(3);
		// c.display();
		//
		// c.removeFirst();
		// c.display();
		//
		// // c.insertLast(4);
		//
		// c.removeLast();
		// c.display();

		// LinearDoublyLinkedList d = new LinearDoublyLinkedList();
		// d.insertFirst(1);
		// d.display();
		//
		// d.insertFirst(0);
		// d.display();
		//
		// d.insertLast(2);
		// d.display();
		//
		// d.insertAt(3, 3);
		// d.display();
		//
		// d.insertAt(2, 4);
		// d.display();
		//
		// d.deleteFirst();
		// d.display();
		//
		// d.deleteLast();
		// d.display();
		//
		// d.deleteAt(1);
		// d.display();

		DynamicLinkedList l1 = new DynamicLinkedList();
		l1.insertFirst(10);
		l1.insertLast(11);
		l1.insertLast(12);
		l1.display();
		
		DynamicLinkedList l2 = new DynamicLinkedList();
		l2.insertFirst(10);
		l2.insertLast(11);
		l2.insertLast(12);
		l2.insertLast(20);
		l2.display();
		
		l1.printIntersection(l2);

		

	}
}
