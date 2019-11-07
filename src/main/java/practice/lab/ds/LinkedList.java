package practice.lab.ds;

public class LinkedList<T> {

	Node head;

	public Node reverseList(Node head) {
		Node previous = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		current = previous;

		return current;
	}

	public int hasLoop(Node head) {

		Node fast = head, slow = head;

		while (fast != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				int loopSize = 1;
				slow = slow.next;

				while (slow != fast) {
					slow = slow.next;
					loopSize++;
				}
				return loopSize;
			}
		}

		return 0;
	}

	public void push(T item) {
		Node node = new Node(item);
		node.next = head;
		head = node;
	}

	public void insertNode(T item) {
		Node node = new Node(item);
		Node current = head;
		if (current == null) {
			head = node;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	private class Node {
		private T item;
		private Node next;

		public Node(T item) {
			this.next = null;
			this.item = item;
		}

	}

}
