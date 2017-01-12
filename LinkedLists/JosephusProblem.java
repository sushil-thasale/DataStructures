import java.util.Random;

class NameNode {
	public String name;
	public NameNode next;

	public NameNode(String name) {
		this.name = name;
		this.next = null;
	}
}

/*
 * Josephous problem is about group of soldiers who have lost the battle
 * and want to return. However, they have only 1 horse.
 * So this problem helps in finding 1 soldier who can escape
 * This problem is solved using circular linked list
 */
public class JosephusProblem {

	private NameNode last;
	private int size;
	private int circleSize; 

	// provide names of participants and random circleSize
	public JosephusProblem(String[] names, int circleSize) {
		last = null;
		size = 0;
		this.circleSize = circleSize;

		// add participants to circular linked list
		for (String name : names) {
			insert(name);
		}
	}

	public boolean isEmpty() {
		return (last == null);
	}

	// insert names into circular link list
	public void insert(String name) {
		NameNode item = new NameNode(name);
		if (isEmpty()) {
			last = item;
			last.next = last;
		} else {
			item.next = last.next;
			last.next = item;
			last = item;
		}
		size++;
	}

	// print the name of last person left in group of people
	public void getEscaper() {

		NameNode start = getRandomStartingPoint();
		System.out.println("starting from : " + start.name);

		// eliminate 1 person from group until 1 person is left
		while (size != 1) {
			int count = 1;
			NameNode temp = start;
			NameNode prevTemp = null;
			while (count != circleSize) {
				prevTemp = temp;
				temp = temp.next;
				count++;
			}
			System.out.println("Person removed : " + temp.name);
			if (temp == last) {
				last = prevTemp;
			}

			prevTemp.next = temp.next;
			start = prevTemp.next;
			size--;
		}
		System.out.println("Person who will escape is " + last.name);
	}

	// get a random starting point
	public NameNode getRandomStartingPoint() {
		Random rand = new Random();
		// random number between 0 to size-1
		int num = rand.nextInt(size);

		NameNode temp = last.next;
		int count = 0;
		while (count != num) {
			temp = temp.next;
			count++;
		}

		return temp;
	}
}
