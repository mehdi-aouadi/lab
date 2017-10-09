package mehdi.practice.lab.ds;

public class BinaryTree {

	Node root;

	public boolean isBinarySearchTree(Node root) {
		return (isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private boolean isBSTUtil(Node node, int minValue, int maxValue) {

		if (node == null) {
			return true;
		}
		if (node.data < minValue || node.data > maxValue) {
			return false;
		}
		return (isBSTUtil(node.left, minValue, node.data - 1) && isBSTUtil(node.right, node.data - 1, maxValue));

	}

	private class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

}
